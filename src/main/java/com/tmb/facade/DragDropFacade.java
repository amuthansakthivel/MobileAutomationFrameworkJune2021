package com.tmb.facade;

import com.tmb.pages.DragAndDropPageNative;
import com.tmb.pages.HomePageNative;

public class DragDropFacade {

    public DragDropFacade navigateToDragAndDropPage(){
         new HomePageNative()
                 .clickOnViews()
                 .clickAMenuItem("Drag and Drop");
         return this;
    }

    public DragAndDropPageNative getDragAndDropPage(){
        return new DragAndDropPageNative();
    }
}
