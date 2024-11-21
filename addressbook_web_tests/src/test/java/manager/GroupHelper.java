package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager) {
        super(manager);

    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    // Подтверждение создания группы
    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    // Запуск создания группы
    private void initGroupCreation() {
        click(By.name("new"));
    }

    // Удаление выбранных групп
    private void removeSelectedGroups() {
        click(By.name("delete"));
    }

    // Возврат на страницу групп
    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    // Подтверждение изменений группы
    private void submitGroupModification() {
        click(By.name("update"));
    }

    // Заполнение формы группы
    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    // Запуск изменения группы
    private void initGroupModification() {
        click(By.name("edit"));
    }

    // Выбор группы
    private void selectGroup() {
        click(By.name("selected[]"));
    }

    // Счетчик групп
    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    // Удаление всех выбранных групп
    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    //Выбор всех групп
    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
