package controllers;

import models.Inventory.Inventory;
import models.Item.ConsumableItem;
import models.StateModel.InventoryViewModel;
import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;

import java.awt.event.KeyEvent;

/**
 * Implemented by Peter Camejo
 */
public class InventoryViewController extends Controller{

    private InventoryViewModel model;

    public InventoryViewController(GameStateManager gsm , InventoryViewModel model){
        super(gsm);
        this.model = model;
    }

    @Override
    public void loadKeyCommand() {

        keyMap.put(KeyEvent.VK_NUMPAD8, new KeyCommand(){
            @Override
            public void execute() {
                model.up();
            }
        });

        keyMap.put(KeyEvent.VK_NUMPAD4, new KeyCommand() {
            @Override
            public void execute() {
                model.left();
            }
        });

        keyMap.put(KeyEvent.VK_NUMPAD6, new KeyCommand(){
            @Override
            public void execute() {
                model.right();
            }
        });

        keyMap.put(KeyEvent.VK_NUMPAD2, new KeyCommand() {
            @Override
            public void execute() {
                model.down();
            }
        });

        keyMap.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute(){model.select(); }
        });

        keyMap.put(KeyEvent.VK_ESCAPE, new KeyCommand() {
            @Override
            public void execute() {
                gsm.removeState(); //Go back to playState
            }
        });
    }

    @Override
    public void handleInput(KeyEvent e) {
        super.handleInput(e);
    }

    @Override
    public void updateModel() {

    }
}
