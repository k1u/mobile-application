package com.jenky.codebuddy.util;

import com.jenky.codebuddy.models.Achievement;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.models.Tower;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by JTLie on 22-5-2016.
 */
public class TestData {

    public static void addTestTowers(ArrayList<Tower> towers) {
        for (int i = 0; i < 60; i++) {
            Tower tower = new Tower();
            tower.setHeight(i + 1);
            tower.setScore(i * 1000);
            tower.setBlock("http://i.imgur.com/b80yEkL.png");
            towers.add(tower);
        }
    }

    public static void addTestAchievments(ArrayList<Achievement> achievements) {
        for (int i = 0; i < 10; i++) {
            Achievement achievement = new Achievement();
            achievement.setName("name" + i);
            achievement.setComplete_percentage((double) i);
            achievement.setId(i);
            achievement.setDescription("description" + i);
            achievements.add(achievement);
        }

    }


    public static void addTestProjects(ArrayList<Project> projects) {
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
    }

    public static void addTestBlocks(ArrayList<Item> items) {
        Random rand = new Random();
        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item.setName("Orange Bricks");
        item.setType("block");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("http://i.imgur.com/b80yEkL.png");
        items.add(item);

        item2.setId(2);
        item2.setName("Dark Bricks");
        item2.setType("block");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("http://i.imgur.com/8jMc9dy.png");
        items.add(item2);


    }

    public static void addTestHelmets(ArrayList<Item> items) {
        Random rand = new Random();
        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item.setName("Bat Helm");
        item.setType("helmet");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("http://i.imgur.com/UCGB5Rn.png");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron Helm");
        item2.setType("helmet");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("http://i.imgur.com/Ug5XFCo.png");
        items.add(item2);


    }

    public static void addTestShirts(ArrayList<Item> items) {
        Random rand = new Random();

        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item.setName("Bat Shirt");
        item.setType("shirt");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("http://i.imgur.com/cAcMw06.png");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron shirt");
        item2.setType("shirt");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("http://i.imgur.com/DRh6lWk.png");
        items.add(item2);

    }

    public static void addTestLegs(ArrayList<Item> items) {
        Random rand = new Random();
        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item.setName("Bat Legs");
        item.setType("legs");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("http://i.imgur.com/THzZGs7.png");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron Legs");
        item2.setType("legs");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("http://i.imgur.com/1B02FqW.png");
        items.add(item2);

    }
}
