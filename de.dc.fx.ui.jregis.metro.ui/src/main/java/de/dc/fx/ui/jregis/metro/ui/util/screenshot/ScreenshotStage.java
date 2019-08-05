package de.dc.fx.ui.jregis.metro.ui.util.screenshot;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ScreenshotStage extends Stage{

	public ScreenshotStage(boolean isFullscreen) {
		ScreenshotSelection screenshotSelection = new ScreenshotSelection(this, isFullscreen);
        Scene scene = new Scene(screenshotSelection);
        setScene(scene);
        scene.setFill(Paint.valueOf("#ffffff00"));
        setFullScreenExitHint("");
        initStyle(StageStyle.TRANSPARENT);
        setFullScreen(true);
			close();
        show();
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                close();
            }
        });

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            String name = e.getButton().name();
            if (name.equals(MouseButton.SECONDARY.name())) {
                close();
            }
        });
	}
}
