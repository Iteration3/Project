package views;

import models.StateModel.PlayStateModel;
import utilities.Location.Location;

import java.awt.*;


/**
 * This class is the Master View for the game
 *   - Handles Rendering the AreaViewport
 *   - Handles Rendering the StatusViewPort
 *   - Handles Rendering the SkillsViewPort
 */
public class PlayStateView extends View {

    private MapView mapView;
    protected PlayStateModel model;

    public PlayStateView(int width, int height, Canvas canvas, PlayStateModel model) {
        super(width,height,canvas);
        this.model = model;

        mapView = this.model.getMapView();

        mapView.setCenter(this.model.getFocus());

    }

    @Override
    protected void render(Graphics g) {
        mapView.setCenter(model.getFocus());
        mapView.render(getScreenWidth(),getScreenHeight(),g);
    }



}