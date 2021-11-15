package com.example.projectlast;

import java.util.ArrayList;

public interface UpdateSelectedItems {
    void addItems(String name , int price);


    ArrayList<OrderListModel> getItems();
}
