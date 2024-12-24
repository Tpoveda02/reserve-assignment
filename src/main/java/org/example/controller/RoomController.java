package org.example.controller;

import org.example.model.Room;
import org.example.view.GeneralView;

import java.util.List;

public class RoomController {

    private List<Room> rooms;
    private GeneralView generalView;

    public RoomController(List<Room> rooms, GeneralView roomView) {
        this.rooms = rooms;
        this.generalView = generalView;
    }
}

