package utilities.State;

import controllers.InventoryEquipmentController;
import models.Entity.Entity;
import models.StateModel.InventoryEquipmentModel;
import views.StateView.InventoryEquipmentView;

/**
 * Implemented by Peter Camejo
 */
public class InventoryEquipmentState extends State {
    private Entity entity;

    public InventoryEquipmentState(){
        entity = null;
    }

    public InventoryEquipmentState(Entity entity){
        this.entity = entity;
    }

    public void initMVC(){
        InventoryEquipmentModel model = new InventoryEquipmentModel(entity);
        InventoryEquipmentController controller = new InventoryEquipmentController(model);
        InventoryEquipmentView view = new InventoryEquipmentView();

        setMVC(model,view,controller);
    }
}
