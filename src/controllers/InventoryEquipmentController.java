package controllers;

import models.Inventory.Inventory;
import models.Item.ConsumableItem;
import models.StateModel.InventoryEquipmentModel;
import utilities.KeyCommand;

import java.awt.event.KeyEvent;

/**
 * Implemented by Peter Camejo
 */
public class InventoryEquipmentController extends Controller{
    private InventoryEquipmentModel model;

    public InventoryEquipmentController(InventoryEquipmentModel model){
        this.model = model;
    }

    public void loadKeyCommand() {

        map.put(KeyEvent.VK_NUMPAD8, new KeyCommand(){
            @Override
            public void execute() {
                model.up();
            }
        });

        map.put(KeyEvent.VK_NUMPAD2, new KeyCommand() {
            @Override
            public void execute() {
                model.down();
            }
        });

        map.put(KeyEvent.VK_NUMPAD4, new KeyCommand() {
            @Override
            public void execute() {
                model.left();
            }
        });

        map.put(KeyEvent.VK_NUMPAD6, new KeyCommand() {
            @Override
            public void execute() {
                model.right();
            }
        });


        map.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute() {
                model.select();
            }
        });

        /* map.put(KeyEvent.VK_ESC ============= go back to last state */
    }
}
