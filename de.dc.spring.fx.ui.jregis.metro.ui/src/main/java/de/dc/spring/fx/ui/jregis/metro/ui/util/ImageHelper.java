package de.dc.spring.fx.ui.jregis.metro.ui.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class ImageHelper {

	public static void saveToFile(String filePatn, Image image) {
		File outputFile = new File(filePatn);
		BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
		try {
			ImageIO.write(bImage, "png", outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Optional<Image> getImageFX() {
		java.awt.Image awtImage = getImageFromClipboard();
		try {
			return Optional.ofNullable(awtImageToFX(awtImage));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static java.awt.Image getImageFromClipboard() {
		Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor)) {
			try {
				return (java.awt.Image) transferable.getTransferData(DataFlavor.imageFlavor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static javafx.scene.image.Image awtImageToFX(java.awt.Image image) throws Exception {
		if (!(image instanceof RenderedImage)) {
			BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
					BufferedImage.TYPE_INT_ARGB);
			Graphics g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, null);
			g.dispose();

			image = bufferedImage;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write((RenderedImage) image, "png", out);
		out.flush();
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		return new javafx.scene.image.Image(in);
	}

	public static Image blobToImage(Blob blob) {
		try {
			InputStream binaryStream = blob.getBinaryStream();
			return new Image(binaryStream);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Image iconToImageFX(Icon icon) {
		java.awt.Image awtImage = iconToImage(icon);
		try {
			return awtImageToFX(awtImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static java.awt.Image iconToImage(Icon icon) {
		if (icon instanceof ImageIcon) {
			return ((ImageIcon) icon).getImage();
		} else {
			int w = icon.getIconWidth();
			int h = icon.getIconHeight();
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gd.getDefaultConfiguration();
			BufferedImage image = gc.createCompatibleImage(w, h);
			Graphics2D g = image.createGraphics();
			icon.paintIcon(null, g, 0, 0);
			g.dispose();
			return image;
		}
	}
}
