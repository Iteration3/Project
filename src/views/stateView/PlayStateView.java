package views.stateView;

import models.StateModel.PlayStateModel;
import utilities.Location.Location;
import views.View;
import views.other.MapView;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayStateView extends View {

    private MapView mapView;
    protected PlayStateModel model;

    public PlayStateView(PlayStateModel model) {
        this.model = model;

        mapView = this.model.getMapView();
        //mapView.setCenter(this.model.getFocus().getLocation());
        mapView.setCenter(new Location(0,0,0));
    }

    @Override
    protected void render(Graphics2D g) {
        int width = getWidth();
        int height = getHeight();

        BufferedImage image = new BufferedImage(width,height,1);
        //mapView.setCenter(model.getFocus().getLocation());
        mapView.render(image);

        g.drawImage(image,0,0,width,height,null);
    }
}