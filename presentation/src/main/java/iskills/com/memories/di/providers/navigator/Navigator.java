package iskills.com.memories.di.providers.navigator;

import android.app.Activity;
import android.content.Intent;

import iskills.com.memories.MainActivity;
import iskills.com.memories.ui.addMemory.ViewAddMemory;
import iskills.com.memories.ui.allMemories.ViewGetAllMemories;

/**
 * lennyhicks
 * 4/4/18
 */
public class Navigator {
    private Activity activity;


    Navigator(MainActivity activity){
        this.activity = activity;
    }

    void toAddMemoriesScreen(){
        Intent intent = new Intent(activity, ViewAddMemory.class);
        activity.startActivity(intent);
    }


    void toAllMemoriesScreen(){
        Intent intent = new Intent(activity, ViewGetAllMemories.class);
        activity.startActivity(intent);
    }


    void toMapMemoryScreen(){
        Intent intent = new Intent(activity, ViewAddMemory.class);
        activity.startActivity(intent);
    }


}
