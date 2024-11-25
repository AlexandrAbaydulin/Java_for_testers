package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.GroupData;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

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

    public void removeGroup(GroupData group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData group, GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup(group);
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
    private void selectGroup(GroupData group) {
        click(By.cssSelector(String.format("input[value='%s']", group.id())));
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
        manager.driver
                .findElements(By.name("selected[]"))
                .forEach(WebElement::click);
    }

    public List<GroupData> getList() {
        openGroupsPage();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        return spans.stream()
                .map(span -> {
                    var name = span.getText();
                    var checkbox = span.findElement(By.name("selected[]"));
                    var id = checkbox.getAttribute("value");
                    return new GroupData()
                            .withId(id)
                            .withName(name);
                })
                .collect(Collectors.toList());
//        for (var span : spans) {
//            var name = span.getText();
//            var checkbox = span.findElement(By.name("selected[]"));
//            var id = checkbox.getAttribute("value");
//            groups.add(new GroupData()
//                    .withId(id)
//                    .withName(name));
//        }
//        return groups;
    }
}
