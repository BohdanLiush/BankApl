package apk.win.first.bankapl;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import apk.win.first.bankapl.apk.win.first.valuesmoney.AED;
import apk.win.first.bankapl.apk.win.first.valuesmoney.AMD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.AUD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.AZN;
import apk.win.first.bankapl.apk.win.first.valuesmoney.BGN;
import apk.win.first.bankapl.apk.win.first.valuesmoney.BRL;
import apk.win.first.bankapl.apk.win.first.valuesmoney.BYN;
import apk.win.first.bankapl.apk.win.first.valuesmoney.CAD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.CHF;
import apk.win.first.bankapl.apk.win.first.valuesmoney.CLP;
import apk.win.first.bankapl.apk.win.first.valuesmoney.CNY;
import apk.win.first.bankapl.apk.win.first.valuesmoney.CZK;
import apk.win.first.bankapl.apk.win.first.valuesmoney.DKK;
import apk.win.first.bankapl.apk.win.first.valuesmoney.EGP;
import apk.win.first.bankapl.apk.win.first.valuesmoney.EUR;
import apk.win.first.bankapl.apk.win.first.valuesmoney.GBP;
import apk.win.first.bankapl.apk.win.first.valuesmoney.GEL;
import apk.win.first.bankapl.apk.win.first.valuesmoney.HKD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.HRK;
import apk.win.first.bankapl.apk.win.first.valuesmoney.HUF;
import apk.win.first.bankapl.apk.win.first.valuesmoney.ILS;
import apk.win.first.bankapl.apk.win.first.valuesmoney.INR;
import apk.win.first.bankapl.apk.win.first.valuesmoney.IQD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.JPY;
import apk.win.first.bankapl.apk.win.first.valuesmoney.KRW;
import apk.win.first.bankapl.apk.win.first.valuesmoney.KWD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.KZT;
import apk.win.first.bankapl.apk.win.first.valuesmoney.LBP;
import apk.win.first.bankapl.apk.win.first.valuesmoney.MDL;
import apk.win.first.bankapl.apk.win.first.valuesmoney.MXN;
import apk.win.first.bankapl.apk.win.first.valuesmoney.NOK;
import apk.win.first.bankapl.apk.win.first.valuesmoney.NZD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.PLN;
import apk.win.first.bankapl.apk.win.first.valuesmoney.RON;
import apk.win.first.bankapl.apk.win.first.valuesmoney.RUB;
import apk.win.first.bankapl.apk.win.first.valuesmoney.SAR;
import apk.win.first.bankapl.apk.win.first.valuesmoney.SEK;
import apk.win.first.bankapl.apk.win.first.valuesmoney.SGD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.THB;
import apk.win.first.bankapl.apk.win.first.valuesmoney.TMT;
import apk.win.first.bankapl.apk.win.first.valuesmoney.TRY;
import apk.win.first.bankapl.apk.win.first.valuesmoney.TWD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.USD;
import apk.win.first.bankapl.apk.win.first.valuesmoney.VND;

public class Currencies extends ModelCurrenciesBasic implements Serializable{

    @SerializedName("EUR")
    @Expose
    private EUR eUR;
    @SerializedName("RUB")
    @Expose
    private RUB rUB;
    @SerializedName("USD")
    @Expose
    private USD uSD;
    @SerializedName("AED")
    @Expose
    private AED aED;
    @SerializedName("AMD")
    @Expose
    private AMD aMD;
    @SerializedName("AUD")
    @Expose
    private AUD aUD;
    @SerializedName("AZN")
    @Expose
    private AZN aZN;
    @SerializedName("BGN")
    @Expose
    private BGN bGN;
    @SerializedName("BRL")
    @Expose
    private BRL bRL;
    @SerializedName("BYN")
    @Expose
    private BYN bYN;
    @SerializedName("CAD")
    @Expose
    private CAD cAD;
    @SerializedName("CHF")
    @Expose
    private CHF cHF;
    @SerializedName("CLP")
    @Expose
    private CLP cLP;
    @SerializedName("CNY")
    @Expose
    private CNY cNY;
    @SerializedName("CZK")
    @Expose
    private CZK cZK;
    @SerializedName("DKK")
    @Expose
    private DKK dKK;
    @SerializedName("EGP")
    @Expose
    private EGP eGP;
    @SerializedName("GBP")
    @Expose
    private GBP gBP;
    @SerializedName("GEL")
    @Expose
    private GEL gEL;
    @SerializedName("HKD")
    @Expose
    private HKD hKD;
    @SerializedName("HRK")
    @Expose
    private HRK hRK;
    @SerializedName("HUF")
    @Expose
    private HUF hUF;
    @SerializedName("ILS")
    @Expose
    private ILS iLS;
    @SerializedName("INR")
    @Expose
    private INR iNR;
    @SerializedName("JPY")
    @Expose
    private JPY jPY;
    @SerializedName("KRW")
    @Expose
    private KRW kRW;
    @SerializedName("KWD")
    @Expose
    private KWD kWD;
    @SerializedName("KZT")
    @Expose
    private KZT kZT;
    @SerializedName("LBP")
    @Expose
    private LBP lBP;
    @SerializedName("MDL")
    @Expose
    private MDL mDL;
    @SerializedName("MXN")
    @Expose
    private MXN mXN;
    @SerializedName("NOK")
    @Expose
    private NOK nOK;
    @SerializedName("NZD")
    @Expose
    private NZD nZD;
    @SerializedName("PLN")
    @Expose
    private PLN pLN;
    @SerializedName("RON")
    @Expose
    private RON rON;
    @SerializedName("SAR")
    @Expose
    private SAR sAR;
    @SerializedName("SEK")
    @Expose
    private SEK sEK;
    @SerializedName("SGD")
    @Expose
    private SGD sGD;
    @SerializedName("THB")
    @Expose
    private THB tHB;
    @SerializedName("TRY")
    @Expose
    private TRY tRY;
    @SerializedName("TWD")
    @Expose
    private TWD tWD;
    @SerializedName("VND")
    @Expose
    private VND vND;
    @SerializedName("IQD")
    @Expose
    private IQD iQD;
    @SerializedName("TMT")
    @Expose
    private TMT tMT;



    public EUR getEUR() {
        return eUR;
    }

    public void setEUR(EUR eUR) {
        this.eUR = eUR;
    }

    public RUB getRUB() {
        return rUB;
    }

    public void setRUB(RUB rUB) {
        this.rUB = rUB;
    }

    public USD getUSD() {
        return uSD;
    }

    public void setUSD(USD uSD) {
        this.uSD = uSD;
    }

    public AED getAED() {
        return aED;
    }

    public void setAED(AED aED) {
        this.aED = aED;
    }

    public AMD getAMD() {
        return aMD;
    }

    public void setAMD(AMD aMD) {
        this.aMD = aMD;
    }

    public AUD getAUD() {
        return aUD;
    }

    public void setAUD(AUD aUD) {
        this.aUD = aUD;
    }

    public AZN getAZN() {
        return aZN;
    }

    public void setAZN(AZN aZN) {
        this.aZN = aZN;
    }

    public BGN getBGN() {
        return bGN;
    }

    public void setBGN(BGN bGN) {
        this.bGN = bGN;
    }

    public BRL getBRL() {
        return bRL;
    }

    public void setBRL(BRL bRL) {
        this.bRL = bRL;
    }

    public BYN getBYN() {
        return bYN;
    }

    public void setBYN(BYN bYN) {
        this.bYN = bYN;
    }

    public CAD getCAD() {
        return cAD;
    }

    public void setCAD(CAD cAD) {
        this.cAD = cAD;
    }

    public CHF getCHF() {
        return cHF;
    }

    public void setCHF(CHF cHF) {
        this.cHF = cHF;
    }

    public CLP getCLP() {
        return cLP;
    }

    public void setCLP(CLP cLP) {
        this.cLP = cLP;
    }

    public CNY getCNY() {
        return cNY;
    }

    public void setCNY(CNY cNY) {
        this.cNY = cNY;
    }

    public CZK getCZK() {
        return cZK;
    }

    public void setCZK(CZK cZK) {
        this.cZK = cZK;
    }

    public DKK getDKK() {
        return dKK;
    }

    public void setDKK(DKK dKK) {
        this.dKK = dKK;
    }

    public EGP getEGP() {
        return eGP;
    }

    public void setEGP(EGP eGP) {
        this.eGP = eGP;
    }

    public GBP getGBP() {
        return gBP;
    }

    public void setGBP(GBP gBP) {
        this.gBP = gBP;
    }

    public GEL getGEL() {
        return gEL;
    }

    public void setGEL(GEL gEL) {
        this.gEL = gEL;
    }

    public HKD getHKD() {
        return hKD;
    }

    public void setHKD(HKD hKD) {
        this.hKD = hKD;
    }

    public HRK getHRK() {
        return hRK;
    }

    public void setHRK(HRK hRK) {
        this.hRK = hRK;
    }

    public HUF getHUF() {
        return hUF;
    }

    public void setHUF(HUF hUF) {
        this.hUF = hUF;
    }

    public ILS getILS() {
        return iLS;
    }

    public void setILS(ILS iLS) {
        this.iLS = iLS;
    }

    public INR getINR() {
        return iNR;
    }

    public void setINR(INR iNR) {
        this.iNR = iNR;
    }

    public JPY getJPY() {
        return jPY;
    }

    public void setJPY(JPY jPY) {
        this.jPY = jPY;
    }

    public KRW getKRW() {
        return kRW;
    }

    public void setKRW(KRW kRW) {
        this.kRW = kRW;
    }

    public KWD getKWD() {
        return kWD;
    }

    public void setKWD(KWD kWD) {
        this.kWD = kWD;
    }

    public KZT getKZT() {
        return kZT;
    }

    public void setKZT(KZT kZT) {
        this.kZT = kZT;
    }

    public LBP getLBP() {
        return lBP;
    }

    public void setLBP(LBP lBP) {
        this.lBP = lBP;
    }

    public MDL getMDL() {
        return mDL;
    }

    public void setMDL(MDL mDL) {
        this.mDL = mDL;
    }

    public MXN getMXN() {
        return mXN;
    }

    public void setMXN(MXN mXN) {
        this.mXN = mXN;
    }

    public NOK getNOK() {
        return nOK;
    }

    public void setNOK(NOK nOK) {
        this.nOK = nOK;
    }

    public NZD getNZD() {
        return nZD;
    }

    public void setNZD(NZD nZD) {
        this.nZD = nZD;
    }

    public PLN getPLN() {
        return pLN;
    }

    public void setPLN(PLN pLN) {
        this.pLN = pLN;
    }

    public RON getRON() {
        return rON;
    }

    public void setRON(RON rON) {
        this.rON = rON;
    }

    public SAR getSAR() {
        return sAR;
    }

    public void setSAR(SAR sAR) {
        this.sAR = sAR;
    }

    public SEK getSEK() {
        return sEK;
    }

    public void setSEK(SEK sEK) {
        this.sEK = sEK;
    }

    public SGD getSGD() {
        return sGD;
    }

    public void setSGD(SGD sGD) {
        this.sGD = sGD;
    }

    public THB getTHB() {
        return tHB;
    }

    public void setTHB(THB tHB) {
        this.tHB = tHB;
    }

    public TRY getTRY() {
        return tRY;
    }

    public void setTRY(TRY tRY) {
        this.tRY = tRY;
    }

    public TWD getTWD() {
        return tWD;
    }

    public void setTWD(TWD tWD) {
        this.tWD = tWD;
    }

    public VND getVND() {
        return vND;
    }

    public void setVND(VND vND) {
        this.vND = vND;
    }

    public IQD getIQD() {
        return iQD;
    }

    public void setIQD(IQD iQD) {
        this.iQD = iQD;
    }

    public TMT getTMT() {
        return tMT;
    }

    public void setTMT(TMT tMT) {
        this.tMT = tMT;
    }

}
