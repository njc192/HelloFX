package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;

public enum Rank {


    ACEofHEARTS(  new Heart(),"A",1,11),
    TWOofHEARTS(  new Heart(),"2"),
    THREEofHEARTS(new Heart(),"3"),
    FOURofHEARTS( new Heart(),"4"),
    FIVEofHEARTS( new Heart(),"5"),
    SIXofHEARTS(  new Heart(),"6"),
    SEVENofHEARTS(new Heart(),"7"),
    EIGHTofHEARTS(new Heart(),"8"),
    NINEofHEARTS( new Heart(),"9"),
    TENofHEARTS(  new Heart(),"10"),
    JACKofHEARTS( new Heart(),"J",10),
    QUEENofHEARTS(new Heart(),"Q",10),
    KINGofHEARTS( new Heart(),"K",10),



    ACEofDIAMONDS(  new Diamond(),"A",1,11),
    TWOofDIAMONDS(  new Diamond(),"2"),
    THREEofDIAMONDS(new Diamond(),"3"),
    FOURofDIAMONDS( new Diamond(),"4"),
    FIVEofDIAMONDS( new Diamond(),"5"),
    SIXofDIAMONDS(  new Diamond(),"6"),
    SEVENofDIAMONDS(new Diamond(),"7"),
    EIGHTofDIAMONDS(new Diamond(),"8"),
    NINEofDIAMONDS( new Diamond(),"9"),
    TENofDIAMONDS(  new Diamond(),"10"),
    JACKofDIAMONDS( new Diamond(),"J",10),
    QUEENofDIAMONDS(new Diamond(),"Q",10),
    KINGofDIAMONDS( new Diamond(),"K",10),



    ACEofCLUBS(  new Club(),"A",1,11),
    TWOofCLUBS(  new Club(),"2"),
    THREEofCLUBS(new Club(),"3"),
    FOURofCLUBS( new Club(),"4"),
    FIVEofCLUBS( new Club(),"5"),
    SIXofCLUBS(  new Club(),"6"),
    SEVENofCLUBS(new Club(),"7"),
    EIGHTofCLUBS(new Club(),"8"),
    NINEofCLUBS( new Club(),"9"),
    TENofCLUBS(  new Club(),"10"),
    JACKofCLUBS( new Club(),"J",10),
    QUEENofCLUBS(new Club(),"Q",10),
    KINGofCLUBS( new Club(),"K",10),


    ACEofSPADES(  new Spade(),"A",1,11),
    TWOofSPADES(  new Spade(),"2"),
    THREEofSPADES(new Spade(),"3"),
    FOURofSPADES( new Spade(),"4"),
    FIVEofSPADES( new Spade(),"5"),
    SIXofSPADES(  new Spade(),"6"),
    SEVENofSPADES(new Spade(),"7"),
    EIGHTofSPADES(new Spade(),"8"),
    NINEofSPADES( new Spade(),"9"),
    TENofSPADES(  new Spade(),"10"),
    JACKofSPADES( new Spade(),"J",10),
    QUEENofSPADES(new Spade(),"Q",10),
    KINGofSPADES( new Spade(),"K",10);



    private Text text;
    private int value1;
    private int value2;
    private Suit suit;


    Rank(Suit suit,String text)
    {
        this.text = new Text(text);
        this.value1 = Integer.parseInt(text);
        this.value2 = value1;
        this.suit = suit;

    }

    Rank(Suit suit,String text, int r1)
    {
        this(suit,text,r1,r1);
    }
    Rank(Suit suit,String text, int r1,int r2)
    {
        this.text = new Text(text);
        this.suit = suit;
        this.value1 = r1;
        this.value2 = r2;
    }


    public Path getShape()
    {
        return suit.getSuitShape();
    }

    public Text getText()
    {
        return text;
    }

    public Color getColor()
    {
        return suit.getColor();
    }
}
