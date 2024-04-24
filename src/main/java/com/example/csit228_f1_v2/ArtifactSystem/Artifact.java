package com.example.csit228_f1_v2.ArtifactSystem;

import com.example.csit228_f1_v2.Database.DatabaseMethod;
import javafx.scene.image.Image;

import java.util.Random;

public class Artifact {
    String mainStat = "test";
    String sub1 = "test2";
    String sub2= "test3";
    String sub3 = "test4";
    String sub4 = "test5";
    String name = "test6";

    int type;
    String art_type;
    Image img;
    ArtifactType artifactType;

    public Artifact(int type) {
        this.type = type;

    }
    public void pull(){
//        KAPOY RANDOMIZER SIR HAHAHAHDOG
        Random randy = new Random();
        int rMain,rSub,rSub2,sSub3,rSub4;
        switch (type){
            case 0:
                name = "Witch's Flower of Blaze";
                this.art_type = "FLOWER";
                this.mainStat = "HP +4,780";

                rSub = randy.nextInt(45);
                sub1 = "HP +"+rSub+"%";
                rSub = randy.nextInt(42);
                sub2 = "Crit Dmg +"+rSub+"%";
                rSub = randy.nextInt(20);
                sub3 = "Crit Rate +"+rSub+"%";
                rSub = randy.nextInt(30);
                sub4 = "Atk% +"+rSub+"%";


                break;


            case 1:
                name = "Witch's Ever-Burning Plume";
                this.art_type = "FEATHER";
                this.mainStat = "Atk +3110";

                rSub = randy.nextInt(45);
                sub1 = "HP +"+rSub+"%";
                rSub = randy.nextInt(42);
                sub2 = "Crit Dmg +"+rSub+"%";
                rSub = randy.nextInt(20);
                sub3 = "Crit Rate +"+rSub+"%";
                rSub = randy.nextInt(30);
                sub4 = "Atk% +"+rSub+"%";

                break;
            case 2:
                name = "Witch's End Time";
                this.art_type = "SANDS";
                this.mainStat = "Def% +31.1";

                rSub = randy.nextInt(45);
                sub1 = "Def% +"+rSub+"%";
                rSub = randy.nextInt(42);
                sub2 = "Atk% +"+rSub+"%";
                rSub = randy.nextInt(20);
                sub3 = "Crit Rate +"+rSub+"%";
                rSub = randy.nextInt(30);
                sub4 = "HP% +"+rSub+"%";

                break;
            case 3:
                name = "Witch's Heart Flames";
                this.art_type = "GOBLET";
                this.mainStat = "PyroDmg% +44.4";

                rSub = randy.nextInt(45);
                sub1 = "HP% +"+rSub+"%";
                rSub = randy.nextInt(42);
                sub2 = "Def% +"+rSub+"%";
                rSub = randy.nextInt(20);
                sub3 = "Atk% +"+rSub+"%";
                rSub = randy.nextInt(30);
                sub4 = "Energy Recharge% +"+rSub+"%";

                break;
            case 4:
                name = "Witch's Scorching Hat";
                this.art_type = "CIRCLET";
                this.mainStat = "Def% +31.1";

                rSub = randy.nextInt(45);
                sub1 = "Def% +"+rSub+"%";
                rSub = randy.nextInt(42);
                sub2 = "Def +"+rSub;
                rSub = randy.nextInt(20);
                sub3 = "Crit Rate +"+rSub+"%";
                rSub = randy.nextInt(30);
                sub4 = "HP% +"+rSub+"%";
                break;
        }
        DatabaseMethod.insertArtifact(name,mainStat,sub1,sub2,sub3,sub4,art_type);

    }

    public ArtifactType getArtifactType() {
        return artifactType;
    }

    public String getMainStat() {
        return mainStat;
    }

    public String getSub1() {
        return sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public String getSub3() {
        return sub3;
    }

    public String getSub4() {
        return sub4;
    }

    public String getName() {
        return name;
    }

    public String getArt_type() {
        return art_type;
    }
}
