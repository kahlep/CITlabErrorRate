/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uros.citlab.errorrate.kws.measures;

import de.uros.citlab.errorrate.types.KWS.MatchList;
import java.util.List;

/**
 *
 * @author tobias
 */
public class WMeanAveragePrecision extends AveragePrecision {

    @Override
    public double calcMeasure(List<MatchList> matchlists) {
        double sum = 0.0;
        double sumRef = 0.0;
        for (MatchList matchList : matchlists) {
            matchList.sort();
            int refSize = matchList.getRefSize();
            sum += calcAveragePrecision(matchList) * refSize;
            sumRef += refSize;
        }
        return sum / sumRef;
    }

}
