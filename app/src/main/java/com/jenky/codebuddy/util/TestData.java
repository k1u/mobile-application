package com.jenky.codebuddy.util;

import com.jenky.codebuddy.models.Achievement;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.models.Tower;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by JTLie on 22-5-2016.
 */
public class TestData {

    public static ArrayList<Tower> addTestTowers(ArrayList<Tower> towers) {
        for (int i = 0; i < 60; i++) {
            Tower tower = new Tower();
            tower.setHeight(i + 1 );
            tower.setId(i + 1);
            tower.setScore(i * 1000);
            tower.setBlock("http://imgur.com/b80yEkL");
            towers.add(tower);
        }
        return towers;
    }

    public static ArrayList<Achievement> addTestAchievments(ArrayList<Achievement> achievements) {
        for (int i = 0; i < 10; i++) {
            Achievement achievement = new Achievement();
            achievement.setName("name" + i);
            achievement.setComplete_percentage((double) i);
            achievement.setId(i);
            achievement.setDescription("description" + i);
            achievements.add(achievement);
        }
        return achievements;
    }


    public static ArrayList<Project> addTestProjects(ArrayList<Project> projects) {
        for (int i = 0; i < 3; i++) {
            Project project = new Project();
            project.setName("Project " + (i + 1));
            project.setStatus("In Progress");
            project.setId(i + 1);
            project.setScore(i * 625 + 849);
            project.setRank(10 - i);
            project.setMembers(i * 2);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i * -4);
            project.setCreatedOn(cal);
            projects.add(project);
        }
        return projects;
    }

    public static ArrayList<Item> addTestItems(ArrayList<Item> items) {
        for (int i = 0; i < 5; i++) {
            Item item = new Item();
            item.setName("Test" + i);
            item.setType("Test");
            item.setPrice(i * 25);
            items.add(item);
        }
        return items;
    }

}
