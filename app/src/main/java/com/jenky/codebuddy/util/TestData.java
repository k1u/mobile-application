package com.jenky.codebuddy.util;

import com.jenky.codebuddy.models.Achievement;
import com.jenky.codebuddy.models.Commit;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.models.Player;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.models.Tower;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by JTLie on 22-5-2016.
 */
public class TestData {

    public static Player testPlayer() {
        Player player = new Player();
        player.setId(1);
        player.setName("JTLie");
        player.setAchievements(41);
        player.setAvgScore(1234);
        player.setTotalScore(5678);
        player.setGamesPlayed(32);
        player.setJenkyCoins(568);
        Item head = new Item();
        head.setImage("https://lh3.googleusercontent.com/9SeEEoqQVJnQukFN8L60GJGry2US25YSFYm-jtUHNGeGwALnjBQGNKxAlIvD-PFbJpNjTFzqexesK7NYbYQcI3i2pbve7dvge6erPgbAWGKH3rAekByuljje03cOvnUczHXZsT12Tgl--HeHU-ljHlTMJV5dLkNyFfe4s_5IUTriYXnfWdM2e7AYa4WsdTJpX_kr45RB6g53YW0OkxqNXXP5wbcjucMZmuOj2GJwIC0fy4_-cmVfdzKlL1TFQf3GUXE_nZSwIa1E1yhTbp3POEVF-O3UHassGOBA7NkDeW7Yqjw74n0viKqUn7hfrYEs3hTE-VMsSmMyy3bACRCFPgtOwi6AbdwoXi2bf_Rwvgs2l6ftCC5Dk96aFI6N9Hog9qD3g7fN7yJy9Ok-jp7cc9kfB9uc0Nz_rMuEaQrHAD-t9_MzHhdxx_LnSyp72sDwYE6c6H4tp89HHjXCo4oY8WnR8DSpw-18dQJeecmDu1AvE7fWX4LmLOP8CwxmaHLKFe2_VK2WNrUqOoCj7nofoJwDWZy92_oIKhyNxuPpVRri9ZkuguAEEV_IIDChAHD6q8xP1jML61lbi1HRGF303U2xdk-AuQ=w80-h88-no");
        // head.setImage("https://lh3.googleusercontent.com/EINPLbrW_kaqRI6_pe2iz0RaMXBXy4-8IG7RS7Y3QTX8hYoogLPPs40loAT2ilZ9lVZOFBUIPOUtSlrI94WC1jSJNbyML_3l01GSIgz4rlb9ElOzsGbkZELeYGZ87t8AOVdimJszH7DrFJsceieBqcx-dVOPi36LwvBZ0Q2OgevgcwTrvE6Wstj_8RvvxZcd8Ip5jNaBzE_EZVqUtuB9yjP1KbnrS0kTWoPbVyqSH4qrKSE1kxkN4EJ7O_wYiYSsedA-cfjh_SWTkLFjcdgIphObcJ3J83lZYxEBSwrkZJfB7zY_xUPvK3WQxZARzuyA9cOmBllfQAB_qT3X_yVvgpoRxG2EhxQwuUCRC2J3z9a8_RzXL2bHxsNmJWWfju8uGQsW1jAp_PDkdOHI7Fu0vCTnJxnFPcEga_C-xAGEQCUsQFrCtolhxiw5c1sn5ncLqYbeOPJi0Rk2POwIOpRJQi6OHSNiWSd1sqY3t5pgEkS2jk3_OmAraCSJySmG5HeTgm8GHk_a4aZB6hviOmwHObHVIzcGuABYL0M5Ofqt2xqCkAyHXKo8P7RrXLTi1qPiGZErmtsZksqcBpwEVJFTWvunBuy4kw=w80-h88-no");
        Item shirt = new Item();
        shirt.setImage("https://lh3.googleusercontent.com/zBgPUEHB_8lUOoq_7gsTlm3oyoaXM7MPAJwovjvGa3_w9PIiCYG5X81fmv4p-mR4ZZEzrrtLiUubfyHjrLJFKXmNKVnklEnFYb8hOuCPF0kuCOOTV9ct5Zpdcp9Kif9RD_PXbqR8GoiPt6jWqF1pGL0nabghVCfVc1aDX8WhwCMn2HLbPEf36iw3IHkUMpHmzLyyIlG21VKgY9NeX96dTtjcFTMJvjmIIh626g_wm-GiV11UE8VbuoghgtKhSsR_H_jr35txN7HvKFMitJZC9QGvgjxmytkMeddO32klzOp8rjvr5C_Dqacaay6dfe66j6NF16l-JVoTNNaVP8XaYzDiLAwRM6dd4h__uqHtpNHbhnfQrgMI_B_SlPtvrm3B3UIBKE7nYj_vNXc_Eiok68619QvXg4eKasljIxozTWxxwxkWVxWvoeriH-LVrC7UF6nIueHVudZcf-DhpMnzYEbpY8RU7UYywOtn08lzNoMejp1L2OuQOwuk8yL4nQD59CmnqiKLvJifVRfU7UGeH4CAR2gkMKbx0D0qYUA7UXuPtSkDH861SJzh3CWcHOwR7ETWvEJw1xMNhcbqAqhO2dJdu-aJiA=w96-h72-no");
        //shirt.setImage("https://lh3.googleusercontent.com/WptRFxvSkoBQAOi2Xyq-zNwwyabfMC0nZoX-32CKStaL3wNnOtY-Nh66cadpP_5ZNm-2m7uUmQceUk-Vl7jxS2zfpN-QKeLQ6qlyGFhEQ5U65gJ9qe1ZFb_ynurTyNpPqavFsNBbGKg1APzG1Qel-l0gKlHSJUovBu7XGRXZuBSWKOELLnd1KEp_4pzbnC7Z2WHIUtD01aVUoQbrhMHijES2qc5Aaykq-Bv_lqP0fkHU9fGHWDTXI3TvIYISl-IZdQjF2t63sIkPjquzRHD8sLraemWDSjAxY4AU-STirsksZH-RFvSTQACrxa9xZtRGzrUpjJeKXTlmrDqoLHUqhT1vIFayqmbHGeGnUiDmYyYM6okyt6YWbc9hGzey60B1OIk8dD0S_pkgZR6SR2081ggO78CnbSRW__zw5SxT6xKw9ItEPU7pdbZ_TiaGkr3O4CR-zUDZITgQSJ5uRFnf5hapyfTrdSQ2FQ9s7_MNUUJCgwAtO_ZMM34QiArXYIGe-Sqqp38Lc9aUab84vP7b9mj-TQ6-ojZMMzxNONbQOopv-rnU5UpEii318iFUtINnEzrlk7R0h8yBeE6W7iLyy8_SEGcGlw=w96-h72-no");
        Item legs = new Item();
        legs.setImage("https://lh3.googleusercontent.com/KeSfjoQa3zzLgnGS9v_GwSEO2nuqmDJ4MWLBrkNsHXsxLp2Q3q2bb3z-u0YdjdZ-hjhqk6q8O4hwd7ZO2tHDKPPe5SPrZDOPwtVQywQEaW_ocu57qLDMWke5cRUAyppWqgSPFENHhYBaP6WhLx_qhi5xc77NAAPzlxjU8diesPLEGemtPu8NOWUluvXH0Dd5OK89YJe1sZIc3XRhogYiTEFa3O8q3GifwPXILYQUajORfUiOGlLLO9ADN97n9dSN9emRtp3SEBzKRC_gwd3te5sm_iwqUUelO6Z3hbFcUHRrpUYyTKH6NUCFeOlr0es66asK3i-wzT43q_ku0tjVACtaDDZ93ISMXlq0UHoWsn58bETj1XuPBqG0QWTC4IXFUa2lFcy-HtMdOuBCf6Dc48iLQJxOKRGTBhDXJ70K1l931Fz97H3SRXu9yRaglpWVawX9LsSv-9OkAjeEI-oeb--mbcwHBTVv1UftGmnidA8TMXfDJ1nzdHlmsgpILKgspVXCtNt26gHVfaX4xCHUBTmggmdpUrz6kK6slmLcJ93thS-muyMJHdCrbbuDDhvRMPI9IVq8ZavbHvjzDNMU34sohVFvDg=w68-h48-no");
        Item block = new Item();
        block.setImage("https://lh3.googleusercontent.com/gNTLN4wpuR3trhbNIX49ixrHiNLydRO-YjJ6tPlho5oXwp-EbykTNbNlmM_XNobABoesD9d8VuGUcSvtKurmUBNL98BNMs0M3WyQDopy1MYG7xeYIHLBpyae51l-Kx-WdVcUpaER0ElN2U-te7jBNSP3Vi0KHH1b5Yuea9mwrv0-goyh9AmPbNtaweoiTvsKq0cfqMGQEThpMByaLLPjdS1fZtE-DTC0loA1OJVdw75n9VH_UkFpSwznwsteqDHARqWbwlMjHex2YYb8a4earvJ5BBt9XqePEqj7upk7xkcx4IK7r_iD-lO70xsgLFBAwjQ_PXToiYmd9bkMfZYQBWzmVgV0Y07aiORLck3nAeYU93qfN3K3a0eJalxYgXZEC80vcVoPmFRMgbA2CxgyoXLV8n24qqD8SpnvVS2-zXWNfujzn8_gxd1Mx4M41VOClVFZlIm8qFiIZ-uZGdasvRz8yx0Snxr1_I493ZpUjVCGz8bzAaaqm53XmtYcTaUF3YUvcQRxeabOfC034B5_B7YgBEIUINAWVgDFCWTy5N7QVucW1eDhH7_oSkkWe4JBElTlZ_AVaCAiOdQfZdhz4pPPlkntKw=w90-h32-no");
        player.setHead(head);
        player.setShirt(shirt);
        player.setLegs(legs);
        player.setBlock(block);
        return player;
    }

    public static void addTestTowers(ArrayList<Tower> towers) {
        for (int i = 0; i < 10; i++) {
            Tower tower = new Tower();
            tower.setHeight(i * 30 + 1);
            tower.setScore(i * 1000);
            tower.setPlayer(testPlayer());
            towers.add(tower);
        }
    }

    public static void addTestAchievements(ArrayList<Achievement> achievements) {
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

    public static void addTestCommits(ArrayList<Commit> commits) {
        for (int i = 0; i < 3; i++) {
            Commit commit = new Commit();
            commit.setName("Commit " + (i + 1));
            commit.setId(i + 1);
            commit.setScore(i * 625 + 849);
            commit.setBranch("Test Branch " + i);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i * -4);
            commit.setCreatedOn(cal);
            commits.add(commit);
        }
    }

    public static void addTestBlocks(ArrayList<Item> items) {
        Random rand = new Random();
        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item2.setName("Dark Bricks");
        item.setType("block");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("https://lh3.googleusercontent.com/Ep_FRVwdGQtfw3SPYXiFGjkxAm0oqPWHT_zTzDxEMBsqMlLm-tETRtnkQpzRPF4zN69QNBooQH1XzhFCTqkW1787ERjzvziMJi6irvobSxtgkbC3ApRfJakN5T3Yysi0zWrblJDRpxrbMDuhVEyaXdIbjMhjRHGmLqZ-1MxG0tPDYfnvP3QPnonp2vfegOKNerak1waUfOqNQ1GFvBUm315Zh6RGHWs9amGSk58meyLKurYv0G16FQePBe6Nz9_SAqb3nyGyrtNB0Pd3jTRf_ahjxnBHAINTpjlNRgcV1GDM3P2L6X0qY-gSNmUa7Duwxy5UvPDg4sBN6LzaAiq4KlEsMYRFy6gp7bLfgXZFa5_NoMEPyM_D00NjMxZn9-agg4Eckmxy9fVNBMO-j_vnS6_kWNg_aqei_OkEbfI_d941BIZLg2CYDVDFKNz2Ealf58_9LL7dYBFAS4XH2ZTDfYypVYIMIwNLGk8EYKq8rocRS1VaU6W6xoQBv9FrSD-tRqrmFgQehCQ099oGeXGyFfN7X8Ent8hpobaI9RJlkSrLHL59c1MtGeIhjIHza4ibCD-43TeWUbgqFCmM5R2yoW8Frc9pHw=w90-h32-no");
        items.add(item);

        item2.setId(2);
        item.setName("Orange Bricks");
        item2.setType("block");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/LzYpdZCY3c7iRG5Wk8lVfFqFjw_X3X-QAJ2qDAg5I9eybPvYlJN1HxXhZCluIG9ZJNxU6ucKHQAHD5bq3NAPVdratAxiVBGjcWYnKMCtl1EUU6ZBZdxkk7PDlQhZvHZwraG6Ebv96RImOs5eJpGg7Rw9nTeifRBfszOIX9YSzRCTCcGD8vr2FmUqA556cPYc4LpK-5xASh7LtFLqGoJgtazhZVW2shpcTJJ3OqErTp5G5Cxkkm_iiix1LjSys-acOML6F47-JU72etof2X3tKH7FBLcu_oQQw7vaFdRDxUIWKmoKweRIC_uAGRbbacATvhKCj0uwh7io_hz4cAWe5Y2n5SFqIh7RQlWmHJ0AJrUcAxgGWNgb35LV-TRkxoOlMFs31fpwT83aL8iNZGpHxZbW2zprwJRP-dCTHYGJScAJ768ECK37BAmu8T06laz_4nZ8HgfK0pzSLds_QWv38P7ovqJSYiXPd80lPYSSg7n919HAEdxyJQyTVBaU19Wq36-9IjRLc3XjHxcboJIvWifjAl5F8_uv_nkeR2Tee-zdb62nd3FzLX0mDlqePa0c3uTco0L94satS9CgQY930HXpiDJ_Hw=w90-h32-no");
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
        item.setImage("https://lh3.googleusercontent.com/9SeEEoqQVJnQukFN8L60GJGry2US25YSFYm-jtUHNGeGwALnjBQGNKxAlIvD-PFbJpNjTFzqexesK7NYbYQcI3i2pbve7dvge6erPgbAWGKH3rAekByuljje03cOvnUczHXZsT12Tgl--HeHU-ljHlTMJV5dLkNyFfe4s_5IUTriYXnfWdM2e7AYa4WsdTJpX_kr45RB6g53YW0OkxqNXXP5wbcjucMZmuOj2GJwIC0fy4_-cmVfdzKlL1TFQf3GUXE_nZSwIa1E1yhTbp3POEVF-O3UHassGOBA7NkDeW7Yqjw74n0viKqUn7hfrYEs3hTE-VMsSmMyy3bACRCFPgtOwi6AbdwoXi2bf_Rwvgs2l6ftCC5Dk96aFI6N9Hog9qD3g7fN7yJy9Ok-jp7cc9kfB9uc0Nz_rMuEaQrHAD-t9_MzHhdxx_LnSyp72sDwYE6c6H4tp89HHjXCo4oY8WnR8DSpw-18dQJeecmDu1AvE7fWX4LmLOP8CwxmaHLKFe2_VK2WNrUqOoCj7nofoJwDWZy92_oIKhyNxuPpVRri9ZkuguAEEV_IIDChAHD6q8xP1jML61lbi1HRGF303U2xdk-AuQ=w80-h88-no");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron Helm");
        item2.setType("helmet");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/XjDlrI_h7QJfyrRQ3yArQls2Pom_ebwgut470wOAEZ5Ji56agQDVnO1LT7HJ9iBR54JSbRz6E2Vb6wY4SLLWqTMYDJu96uBdbaAeS1Lm9gOK1R1-HRdtF8HsXA7BGUNrHY_GZXOVLDjkbaPnuU_4UkIaCftRAXeHUxQeQ4u20likryBtTDJYhORvPoHDoYpDlp5bVqCf3vmEh42u2aQ-Eif1sEEjfryLiBCd689QqHfjDIYXesk2ouH8YczWflcmucPzNfOWyMJlMq922xBhZmMz1XtCj_aAlZpUkiOEqI-XNYSbBLUIFgCHcCN3M3q3FhCVlerM2e4EDeBrOTGYWZtzc7aLTRn7MUbn46vVFGO8_0tvUP63AwhQwmGhpoH_KQWRPpHYUSqX0duUazXsk-hx1fXyz5LvtAfszMlq82W0sxxnWgNZ5YsDz9MF5b2g1imESGuDgE2fS_XFy4Pb8MKTQwlQqMkPxFSLrg1WQ-1vrdS7taDNlXfTVTFxz0gENtECC6qSYe-olpNL8H_ccKwrW6UILNBhkifjW0MMCyDkUaB_7KASjtQhvPOeq-h8hStlDYJGlckCMTCjpn_2j6XwJeUXRQ=w80-h88-no");
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
        item.setImage("https://lh3.googleusercontent.com/30IyXfBnTthR1vwIS2Bdm0e3LTKGyJeSP-chLODvbCfitFDPDJ2pmUghIf7WlAKmlQKFSsNkC1hjKTMHad3qpMoQVfnvp-hYWL_9v8O0KELpALHhYOI5aL9kCZKCkgUVi5KLzGtLrL46vAMQxzD0kJt3OwtwlqiUPLkcZjbREQSG99FhCwQWBsPyKGIrv6CLQ-_MrUyiV6XAXkrWLcAdYQh9xf847L5gelyKDiR9MMNh6Byy2pxCRRrlZjFbczT-Fqy07TGsXh7rQ_otpzFHdiEngj-WMo4Y-cv-r5KJXHp8su6e9jOPk7PJa-V_vR8oymSqYINVvIWZYBpJB3fV3Ems-wTGglKBdxseCGnDTDRZNL0xClRi_kSPgo6P4nSZwQIEmiomQ8Tb4uTZiMsM5vxOGxgCpJn46H8zy1Cxjul4451a5aW5ldG6CfKYyXR5FlhsrsFjaO8Tpt-juSqhOSml9PY1esoAoKxebNEkjVvbylaxydsWnMd-7Ombps8ayU7X-Zfvurnh8QGOkHJoP3gLMa2B7l0N0C5R9R18gRvhjaN8ag9mIth0vVwQYcnPMyDq4zhAPrJHfcE9iIwj7RBIfednhQ=w96-h72-no");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron shirt");
        item2.setType("shirt");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/zBgPUEHB_8lUOoq_7gsTlm3oyoaXM7MPAJwovjvGa3_w9PIiCYG5X81fmv4p-mR4ZZEzrrtLiUubfyHjrLJFKXmNKVnklEnFYb8hOuCPF0kuCOOTV9ct5Zpdcp9Kif9RD_PXbqR8GoiPt6jWqF1pGL0nabghVCfVc1aDX8WhwCMn2HLbPEf36iw3IHkUMpHmzLyyIlG21VKgY9NeX96dTtjcFTMJvjmIIh626g_wm-GiV11UE8VbuoghgtKhSsR_H_jr35txN7HvKFMitJZC9QGvgjxmytkMeddO32klzOp8rjvr5C_Dqacaay6dfe66j6NF16l-JVoTNNaVP8XaYzDiLAwRM6dd4h__uqHtpNHbhnfQrgMI_B_SlPtvrm3B3UIBKE7nYj_vNXc_Eiok68619QvXg4eKasljIxozTWxxwxkWVxWvoeriH-LVrC7UF6nIueHVudZcf-DhpMnzYEbpY8RU7UYywOtn08lzNoMejp1L2OuQOwuk8yL4nQD59CmnqiKLvJifVRfU7UGeH4CAR2gkMKbx0D0qYUA7UXuPtSkDH861SJzh3CWcHOwR7ETWvEJw1xMNhcbqAqhO2dJdu-aJiA=w96-h72-no");
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
        item.setImage("https://lh3.googleusercontent.com/kkGFSUaA96mvStWKLb31CpP2UEyejc7sjNV-bfFDx6XRqZmIbZ7BCq-8Ptum4H3woSxn78EpIH-SC08IzlHN6OiaI4aihk-Z1L39DHZqulUCBR4eCQPX8cLx7VkEHmsYGh8apg633gvOrTV4Te4qc8L7hiWKPS4JFIHM0wtip6zRF3jymdeTmrRNGLdRMQT76bHyDjXVR5hiRFNMVHRfC_yHbOk1cMQFfhk-GiDQyVJx5zgetAj3dC3jRI1YQgjUdFIwJdn6T1O3rClrj0LPA7vmb6N9fqoZVbmLH_j1rB6PnW4VI-GMnONOTNtE8-0zxYKEcSm56J326JM2EygEWQMgTWxo39-HoLk-BGj7185j8PHtt-zI2hgyVVXy2PjhQAoblwVoMPdev6HnchBh_8nld-qM1ML61zcmwkoAXvI5JJnmDGLbPOIIyL7gcz3hTHqB7RvHt3V3lhCoZ8Ehk8XU_n3CNtCNLgX61318DKVT1Yc49jJ4ew8YmrpinaMtWq_xtrJkYuyqI9Kr7TI4vvjP7QpZfTpasFMW5P0d1A392ORQ4T6GBtR-CAmOKs1GagMx4U9MGxiMPNBSdkryGGaVcGwsCQ=w68-h48-no");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron Legs");
        item2.setType("legs");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/_anQAfM6VnuJdjG9R8-yWGcVUFYCZ0JJBA_7B-2WRJHhPgs0ryo80iHA98dsXWZ_s-HQTkbQE-PENkaKFoVr5n1e8Vvdh5I9wNFpCS41vpINRZAv58aJRinMpH2-U7U61Er2eyF5vCmoiBhnJ1L--K69QT6L0qKY2VNHysAJeh-ZmJxH3mLnAddNwK-zFqWo7Xs-I3qzOYA_sXImHh41vv0iEZbqYdLFvqF32WRU9-nb_JdAlWkB8Ql5thVku4EHTd2MGqX8FXn7zn6SMz1AeWSwQEMTmi5fXcp09K6VQ1T4iFHp_QZQ0eydw3M42xeNe-pzth93_cjMvHA5p5K12SpoWm94WP1Tcx-i57HtJtvb4I3ZyDsL3Z4qDdEPh_tT0l6pI09O2YQuArKoJM4bmmkABhPqsBeHS0N4j3ItPr443qpBpUfR0zMaJvllLzB8qRDnEFLgn39Vtg9yTKl0yN3bG7woaujzbbpUsVmSg07RaWGarfZFhRFIbKzbNn1tZJLW5sp2dhie2JVWCHrbP9jhgOaeli02IjK3RYxQf80MU9bSAt3X1gfzwMHWgAPjCeWE6pMhbYba6njKcYQyOUTSVPOYTQ=w68-h48-no");
        items.add(item2);
    }

}
