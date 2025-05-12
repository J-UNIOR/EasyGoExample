package Service;

import Entity.menuEntity;
import Entity.menuEntityFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Stateless
public class MenuService {

    // Inject the menuEntityFacade to perform CRUD operations on menuEntity
    @EJB
    private menuEntityFacade menuFacade;

    /**
     * Add a new menu item with an image file.
     *
     * @param name        The name of the menu item.
     * @param description The description of the menu item.
     * @param price       The price of the menu item.
     * @param imagePath   The path to the image file.
     * @throws IOException If there is an issue reading the image file.
     */
    public void addMenuItem(String name, String description, double price, String imagePath) throws IOException {
        // Convert the image to byte array
        byte[] imageBytes = convertImageToByteArray(imagePath);

        // Create a new menu entity
        menuEntity menu = new menuEntity(price, name, imageBytes);
        menu.setDescription(description);

        // Persist the menu item in the database
        menuFacade.create(menu);
    }

    /**
     * Convert an image file to a byte array.
     *
     * @param imagePath The path to the image file.
     * @return The byte array representing the image.
     * @throws IOException If there is an issue reading the file.
     */
    private byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        byte[] byteArray = new byte[(int) file.length()];

        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(byteArray);
        }

        return byteArray;
    }

    /**
     * Get all menu items from the database.
     *
     * @return A list of all menu items.
     */
    public List<menuEntity> getAllMenuItems() {
        return menuFacade.findAll();
    }

    /**
     * Update an existing menu item.
     *
     * @param id          The ID of the menu item to update.
     * @param name        The new name of the menu item.
     * @param description The new description of the menu item.
     * @param price       The new price of the menu item.
     * @param imagePath   The path to the new image file (optional).
     * @throws IOException If there is an issue reading the image file.
     */
    public void updateMenuItem(Long id, String name, String description, double price, String imagePath) throws IOException {
        menuEntity menu = menuFacade.find(id);
        if (menu != null) {
            menu.setName(name);
            menu.setDescription(description);
            menu.setPrice(price);

            // If there is a new image, update it
            if (imagePath != null && !imagePath.isEmpty()) {
                byte[] imageBytes = convertImageToByteArray(imagePath);
                menu.setImage(imageBytes);
            }

            // Update the menu item in the database
            menuFacade.edit(menu);
        }
    }

    /**
     * Delete a menu item.
     *
     * @param id The ID of the menu item to delete.
     */
    public void deleteMenuItem(Long id) {
        menuEntity menu = menuFacade.find(id);
        if (menu != null) {
            menuFacade.remove(menu);
        }
    }
}
