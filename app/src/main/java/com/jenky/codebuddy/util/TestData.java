package com.jenky.codebuddy.util;

import com.jenky.codebuddy.models.Achievement;
import com.jenky.codebuddy.models.Commit;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.models.Player;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.models.Tower;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by JTLie on 22-5-2016.
 */
public class TestData {

    private TestData(){
        //Prevent instantiation
    }

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
        Item shirt = new Item();
        shirt.setImage("https://lh3.googleusercontent.com/zBgPUEHB_8lUOoq_7gsTlm3oyoaXM7MPAJwovjvGa3_w9PIiCYG5X81fmv4p-mR4ZZEzrrtLiUubfyHjrLJFKXmNKVnklEnFYb8hOuCPF0kuCOOTV9ct5Zpdcp9Kif9RD_PXbqR8GoiPt6jWqF1pGL0nabghVCfVc1aDX8WhwCMn2HLbPEf36iw3IHkUMpHmzLyyIlG21VKgY9NeX96dTtjcFTMJvjmIIh626g_wm-GiV11UE8VbuoghgtKhSsR_H_jr35txN7HvKFMitJZC9QGvgjxmytkMeddO32klzOp8rjvr5C_Dqacaay6dfe66j6NF16l-JVoTNNaVP8XaYzDiLAwRM6dd4h__uqHtpNHbhnfQrgMI_B_SlPtvrm3B3UIBKE7nYj_vNXc_Eiok68619QvXg4eKasljIxozTWxxwxkWVxWvoeriH-LVrC7UF6nIueHVudZcf-DhpMnzYEbpY8RU7UYywOtn08lzNoMejp1L2OuQOwuk8yL4nQD59CmnqiKLvJifVRfU7UGeH4CAR2gkMKbx0D0qYUA7UXuPtSkDH861SJzh3CWcHOwR7ETWvEJw1xMNhcbqAqhO2dJdu-aJiA=w96-h72-no");
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

    public static void addTestTowers(List<Tower> towers) {
        for (int i = 0; i < 10; i++) {
            Tower tower = new Tower();
            tower.setHeight(i * 30 + 1);
            tower.setScore(i * 1000);
            tower.setPlayer(testPlayer());
            towers.add(tower);
        }
    }

    public static void addTestAchievements(List<Achievement> achievements) {
        for (int i = 0; i < 10; i++) {
            Achievement achievement = new Achievement();
            achievement.setName("name" + i);
            achievement.setComplete_percentage((double) i);
            achievement.setId(i);
            achievement.setDescription("description" + i);
            achievements.add(achievement);
        }
    }


    public static void addTestProjects(List<Project> projects) {
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

    public static void addTestCommits(List<Commit> commits) {
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

    public static void addTestBlocks(List<Item> items) {
        Random rand = new Random();
        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item2.setName("Dark Bricks");
        item.setType("block");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("https://lh3.googleusercontent.com/MwdABlvM0fH3Zy7gZ8VLGq85BdA4gtstbldngPVmW96RbvUK_djf7GAH-hq5S0kt3tv73cE6vbgyRVk8bq5tYerdYg-boPj3gvf3uA3-XlJcG6rPY0BTwEDrhGzMjB4G5maFf8vKxfNv_032nidR3rSX2n4MXj14bU6moUHQmmwLzGHUPNItcSFo_MUWytePN2K-ztP4qHqiK2B_-4up0bjnAX7qHWJenW60kqjPYOniXMaUsGhOYkYGu-Y3y2yGPZRiE92qLbEcdhxIT4oelngA8Md5JnQ_QxzA5LI-Js1I_Yhp1QnRV8YEmfmujAbty4BwZcR_A7_khEqIRplUWTG76DanYTNHFLtW0vaoY-ShIIafG_i9pLIKzUH94vXMBSqPW4qxkrOyWaI9iUjAk_XUDGJOqfcOXc7RrjAozDuXIGhSYcLvqnXCa4cx5nQ6um-JHWmqulsvYOcZKb9yq0L6y0y4cuUMKdRFMclpSMJX2gQYFFqtOIAD7oVIrEVj8RQekkuZ1-0UdD5Ji9ENs98VVQUsyHX5XRlDfapQ2OUeAR7GmphU5WGsbFBsdgUvEvfHYoQvzepFeDoW0IGSNKYs6y6-yw=w90-h32-no");
        items.add(item);

        item2.setId(2);
        item.setName("Orange Bricks");
        item2.setType("block");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/Izqa0FXwbatbtLucTHJ8Y5arDXHXhEsJ-PcjOMolTGXVOMMkDK7g_VihYT-xEekBVIpoCUafOGAdqVREDkMrLnTioNwVRvWBNASkBjqo6KMRs9fSya3D4HvvA32Yr1a5V6z0iMpa-jnOzPBR0uBOscPLXMkxUbmlkTeSpO1M2E1jSFu3w-6jnxOylig_55Jg4h3TdaZ7DLnd59n-C5oE5YBU27a_Ti9yvpmMqQoYtrAJjXnaA9ldHs-wg5rx0mxYrWfCbeUPnBOK2Q1No6qLiFq6D6HZH6cjK6Wp1MC32_Fd1Ar1HOjiQg7dLambDbZL0MIkbc5dxv3gQGatOWFABGBNJbTuZriwzb_M-3xsdFlb2mYmfNg1ed4OtTVOifpU8UvTKbr0LiHPMOMjkEcBx5MQuhem-brEIU2AvDjl9gtH7_mrLOP4NFQcMZpjVFZ-sHe2JaSZPqJl-zloLTfODMgMWWTHeecwMFK9H4kgI9BevAca28c2Sppdme8T9khPetvCxVuvrsAsNDRgZ0z4F738GJ2fiVWgScZZIdecA96u6L_jvBHZWLwQ9KLsJKtK7njMyDTPLJ-adqHnFkCGbmQnhXfBug=w90-h32-no");
        items.add(item2);


    }

    public static void addTestHelmets(List<Item> items) {
        Random rand = new Random();
        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item.setName("Bat Helm");
        item.setType("helmet");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("https://lh3.googleusercontent.com/ZC1JFnmsEHiP_ppywvvnVnR0wAGkh2tiCG3kuOtDlElY7KrO25aJ6hUcDQGwaSF5su5W8m0w683WYdTFkAHQdY-H2NRzXCteycr5z8KYeT28t3lZENCQiQk_wl88Z2Olc5f8WdoSIWcey8Dzv0RxB-lhRSXJOBQpIq7dAkg4PNDr3AYHag5e2o6HkHdqAo73xguSwdTPteFst-ay7dj0dObQBeLHP-4OojF0v8_tsWxPcTAjjl92Q0eGNsBIrPDiJoj_EbPFpMfi_XM6pRKnvVroI4iUK9vyJA6EOTK6AnFtH2OgBPbIICPBmCG3YbAh-PWTtRcedHOGB_bNlQC7jyy8NQQxb8VRzBg4AALFEyrdF9f90KfvZt-lh3fGypwwVAKIxsHqGFSwCaBoR2xFRkueSU8RzPAaQ8KaqWoOT43dtQCtPA5mzkVYZK6_UgqsHchBp-g8XR8LZWmDCRlVbneWWL5dMfZc1mRb4HYNpu9BqYOg5-LvOMw8HbTRhar8PxhRAmhrIEAQ39mcIo28BMEZboulF7VoSLYsn7Fj4ldbn4KIx6yNm3m3OjbpPfLN5rhiZ-gExikGLZmBuWVdHirrTMjz3w=w80-h88-no");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron Helm");
        item2.setType("helmet");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/_t32y33nVSN94QQ9Wzv_T05ZUCxBNCTSEEBbFeG3GRMSmOT0EOFZvXtjZb53zfXji8Rx5xwzLZReyEiMlztO7rY6wghzdfX5OZq01ZLIvxfCWcekASD7ccVI2uDXCiOb1XaBXllu4J5T2VWi8vSqUmzZX0b0-yJ2J8n_ARYVrIeG4ZKU2qHG5vQz-neCdhTuSBoGR7Ee2f4L-FQg_MXmIS7ArPaO6mePY_iHedkx1Pe_7N3AeV8n8rygL5ETSOHsn3OOPMeDNgvNzDgd54PGde2y5-uoa5R7ViJLjdesVgWVsdh6KEJ7H4WvKGSOlASWXzbuKzSC31jOFJ_qOiWqCyJxXxaqIEUK4lx1Jl22GYDLYVT7cBLcYTbraWP4WZX-8eWfvrgp9Mzuc-V4hl-rF3htWVQOup6cZzz9BfhFVeDYb5tErAxzZrYjGAJj89OlT2pJiQaDKk-JWdGpdNx2_n19bhxs43Nza2ruGHuL_M6M5Bd0wY0h7uCuLe9ZsMZCZEkLwykMgwdHfegstfxYAxlX5Nys1kTVXQMmB2Gof4YE6zo8KNguSH5u75ZYKeXeI6seNha5dPJ6c19G4fgGhCpGeooQaA=w80-h88-no");
        items.add(item2);


    }

    public static void addTestShirts(List<Item> items) {
        Random rand = new Random();

        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item.setName("Bat Shirt");
        item.setType("shirt");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("https://lh3.googleusercontent.com/mgsnBmMkLkFyK0XZ66J4Nofmrh8_p2TgihF_az3nsd1e2I5ET0BXtBt2MOEBgQ8GfI5WpGFCAL3lQbp94sEOoyKf2XAdoZbSwn0U_slL2gIh72kgwWr08PzdP4D2pubiB7ftpJp-ZcwdRPfk0kH6Gw2qveXVMajwZrDzxGI05KDnObAENoGAksr7_WyJiQPKDn3tBBOtsDaXGHZY2qawsJiuV5VimyduqmMe7i2S9j8uFkwaLPXv3gPJ8W9RrACDEYxRudcSn4srwaFWWrHjszNrCF_3dRFlJ431KzTXCYWKTHheV2df_IK61HjEw5z9ZqoroyiQevKBZ1wBHJx6gf3xFEYM8owwS2s5zpci6LoTS_tQnA-mllgqH5BFSKcMXPuxy1GP8bwUelovlpnng_CCwBNCeQsKajeBKyFwS8uSWHZf_D0D6TOHQQSR371YxqAz58eGFPMoSK9xEsnltuB_YO-3sy0iW0T4oCb_JhIXHu3ClUTDd7raSEr8tXS-b8LK3zLutacpLDa1f2mrfOcuIwOMGfKohJxoybboYkCjXKzg2jUj3vC5S6EWiHyosoGX816vqdpouK4OG7zOZTzXaQi0MQ=w96-h72-no");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron shirt");
        item2.setType("shirt");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/WlbKDvMRgqyBGWXlVaTcEaV5hQeV9i_bjjlLSTe9WVKNIFRI5G5Sq-uf9G_M6KMdP9rQndTKqWWYmd17YZo_gXAKrSz8ZC1UyZlhUThd9BuXJLGOb_160ja85lrTvd7rNYfG-_D5H6M1xJWJ5HXe23CyCWmTIxSGRojV0J0VzCg1LpSYkciLH3vMZgLC6Bk00PamELaYZtWMVupc73LIM5GckRUHjLfDf5Bl4xocg_ephC6_p_z5qMGpVkvxSqyMytmvRJfW2Y1k-eHmGwvuk9rJEdEQAgkMze4O8poyaGKvWqGiw4uaGfAyMfq8Q7blXfMHR1KqbqMqdLgrq-UPy7kMJ19OtY5r3aupOT_olL4HR7U-3itdIYGy-JTcxlcCBYL1dmhS4cdmcjhHCnBtZINhj_293CG3XhwbUo5HAQp7gaCHhDfdjfHWwdaacCvTBfWeEnNJexStzjar8-QQMunZ6c5gEmtG0CJTmzbbEnmmhZARjk2B246iFumdbTiY5_Hq6DJh5_lomBxH7uRIf--O1oHwkZpeJRmVUuGjDMG7NJ3IoDFLSTK4qHTFhgSrIl1745tC-HTJiCWz9aMFTpnUXFtdVQ=w96-h72-no");
        items.add(item2);

    }

    public static void addTestLegs(List<Item> items) {
        Random rand = new Random();
        Item item = new Item();
        Item item2 = new Item();

        item.setId(1);
        item.setName("Bat Legs");
        item.setType("legs");
        item.setPrice(rand.nextInt(50) + 1);
        item.setImage("https://lh3.googleusercontent.com/MPH9hTnfCckNg3JK9xycYyNjisHAsWUrgH8baqyjbtgL7a8IT9j7_Fn7Po4VnOIgk8Ro7IqVFYT2mkXeIL829FGhhMefWBVfRT2DUcTLzh_J799HFyedtEKS5usDRxf0pJLmyIW1pLwjn9t66bJoP8tsx4qS8cyLdtwZH56s9mVCSS0eps6wczaNUjwcm5216tGTqK7hmYqM1scHPvt0xsixaUbKLQkEW8M4s2JIxGop26YfRPwGyju8p-IsYs4sSUc4mBNrv8KxHsjGbDNvqEOxMkygLwPyM-DF2xW5Wd5AG4RYBzVkSinHP8KTa3H9HNt9GcIju0LVhih2X9ytzy43XZZ4Dx5qOBcnpYUXCyisJABAn7iDU71_4pbhFifa6aRyo6ZFC4YkGXuP4vBlrZztQ1Vu0suV3k5o29GeVxBNdYDJVxLn34kSu1B0qTDS0RLIrdeNMQNYkknO-HMQCB-e_a_1-WoK9UYMKmtjxJjzSPaqGXoEhZ6mxqc36b0SInUoYTXjvNuJUjUcsvDwvSR1Z5PoxoeAXpaUNBPM7EmSPTQn-8LvrRHf0p21JAwGPOJMUphMI4yn0ulBDEoslRx5bfALXA=w68-h48-no");
        items.add(item);

        item2.setId(2);
        item2.setName("Iron Legs");
        item2.setType("legs");
        item2.setPrice(rand.nextInt(50) + 1);
        item2.setImage("https://lh3.googleusercontent.com/1azRHxEL23QMihj1UTWS42FhRHraqMZA7Hy-2ir0n1_p1GpFP_wGZx9-rpGj4Ia7PfZjAb9N4AhqxHkhDLcv3IaSo83zslqAW2iqAKBn4H_UlBkfyJ0KXyxvJJnGEa6todGS_E7Un6wI9-vSLSa_sL_Imv-pM8PB7ZA5R2IWtRdoBeJsNHGVBzxjtmv1FyUkm7OnNMvBtAKvbMK--0wkohl9zj50KDI3MeRpdlXpK_9tIUnZkQ4uRm_Q77ZASvlj0mCcNvJXplu_X406SRWL2ipv02CBUzXRYKpeDFUNM8VvyVgloGuvgmk--4iB2ArqrgrlIIFRDXCk4TPHZjlt1J7-OCjKnceW3FZpZ25o7p98SXbnv6SEWxEbjMJcQ6XJYpHZKZ-coTET642rMYbjXlwXomdRtCQZfgGskhn_COxwKC3Ag7-bz6nCgR7VHwc8-fflHIUp4-dUJR31BL8B78ejf-i4z30YQRPQ_-CFKwN_JKVJ7Fk2-eIqN4X7WUb6qf7iEGmBGPgMhgD3rpZjR2XNPSnPYzeHCtmclGh4yWRwW_WtV8Rc4wFb-wFCHyMFcc3WrucHeLgcq6OjQcwezol2XnxmMg=w68-h48-no");
        items.add(item2);
    }

}
