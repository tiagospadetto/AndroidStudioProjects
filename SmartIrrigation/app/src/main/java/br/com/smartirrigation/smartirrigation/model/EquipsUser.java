package br.com.smartirrigation.smartirrigation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EquipsUser implements Serializable {


    private ArrayList<EquipResponse> EquipamentoInfo ;

    public EquipsUser() {
    }


    public ArrayList<EquipResponse> getEquipamentoInfo() {
        return EquipamentoInfo;
    }

    public void setEquipamentoInfo(ArrayList<EquipResponse> equipamentoInfo) {
        EquipamentoInfo = equipamentoInfo;
    }
}
