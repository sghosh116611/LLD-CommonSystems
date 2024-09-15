package Splitwise.controller;

import Splitwise.entity.Group;

import java.util.List;

public class GroupController {

    public static List<Group> groups;

    public Group addGroup(Group group){
        groups.add(group);
        return group;
    }
}
