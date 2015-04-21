package android.flag.pt.challenge_it.asynctaskdemo;

/**
 * Created by Jorge.Feteira on 21/04/2015.
 */
public class DadosTempo {

    String nomePais;
    String nomeCidade;
    Double tempAct;
    Double tempMax;
    Double tempMin;
    String timeLoad;

    public DadosTempo(String nomePais, String nomeCidade, Double tempAct, Double tempMax, Double tempMin, String timeLoad) {
        this.nomePais = nomePais;
        this.nomeCidade = nomeCidade;
        this.tempAct = tempAct;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.timeLoad = timeLoad;
    }

    public DadosTempo() {
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public void setTempAct(Double tempAct) {
        this.tempAct = tempAct;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public void setTimeLoad(String timeLoad) {
        this.timeLoad = timeLoad;
    }

    public String getNomePais() {
        return nomePais;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public Double getTempAct() {
        return tempAct;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public String getTimeLoad() {
        return timeLoad;
    }
}


