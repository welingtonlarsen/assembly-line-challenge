package com.neogrid.utils;

import com.neogrid.model.ProductionStep;

import java.util.Calendar;
import java.util.List;

public class ApplicationUtils {

    public static void setUpMorningAssemblyLine(List<ProductionStep> productionStepsListOrdened, Calendar morningTimeVariable, Calendar startLunchTime) {
        ProductionStep productionStep = productionStepsListOrdened.get(0);

        for (int index = 0; index < productionStepsListOrdened.size() - 1; index++) {

            DateUtils.sumMinutesInACreatedCalendar(productionStep.getNecessaryTime(), morningTimeVariable);

            if (morningTimeVariable.getTimeInMillis() <= startLunchTime.getTimeInMillis()) {
                DateUtils.sumMinutesInACreatedCalendar(-productionStep.getNecessaryTime(), morningTimeVariable);
                System.out.println(DateUtils.convertCalendarToFormatedString(morningTimeVariable) + " " + productionStep.getDescription());
                productionStepsListOrdened.remove(productionStep);
                DateUtils.sumMinutesInACreatedCalendar(productionStep.getNecessaryTime(), morningTimeVariable);
                index--;
                productionStep = productionStepsListOrdened.get(index + 1);
            } else {
                DateUtils.sumMinutesInACreatedCalendar(-productionStep.getNecessaryTime(), morningTimeVariable);
                productionStep = productionStepsListOrdened.get(index + 1);
            }
        }

        System.out.println(DateUtils.convertCalendarToFormatedString(startLunchTime) + " Almoço");
    }

    public static void setUpAfternoonAssemblyLine(List<ProductionStep> productionStepsListOrdened, Calendar afternoonTimeVariable, Calendar finishAfternoonTime) {
        ProductionStep productionStep = productionStepsListOrdened.get(0);

        for (int index = 0; index < productionStepsListOrdened.size() ; index++) {

            DateUtils.sumMinutesInACreatedCalendar(productionStep.getNecessaryTime(), afternoonTimeVariable);

            if ((afternoonTimeVariable.getTimeInMillis()) < finishAfternoonTime.getTimeInMillis()) {
                DateUtils.sumMinutesInACreatedCalendar(-productionStep.getNecessaryTime(), afternoonTimeVariable);
                System.out.println(DateUtils.convertCalendarToFormatedString(afternoonTimeVariable) + " " + productionStep.getDescription());
                productionStepsListOrdened.remove(productionStep);
                DateUtils.sumMinutesInACreatedCalendar(productionStep.getNecessaryTime(), afternoonTimeVariable);

                if (index <= (productionStepsListOrdened.size() - 1)) {
                    index--;
                    productionStep = productionStepsListOrdened.get(index + 1);
                }
            } else {
                DateUtils.sumMinutesInACreatedCalendar(-productionStep.getNecessaryTime(), afternoonTimeVariable);
                if (index <= (productionStepsListOrdened.size() - 1)) {
                    productionStep = productionStepsListOrdened.get(index);
                }
            }

        }
    }

    public static void setUpLaborGynasticTime(Calendar afternoonTimeVariable, Calendar minimumTimeToLaborGym) {
        if (afternoonTimeVariable.getTimeInMillis() > minimumTimeToLaborGym.getTimeInMillis()) {
            System.out.println(DateUtils.convertCalendarToFormatedString(afternoonTimeVariable) + " Ginástica Laboral");
        }else {
            System.out.println(DateUtils.convertCalendarToFormatedString(minimumTimeToLaborGym) + " Ginástica Laboral");
        }
    }

    public static void createOrganizedAssemblyLines(List<ProductionStep> productionStepsListOrdened){
        int assemblyLineNumber = 1;

        do{
            System.out.println("Linha de montagem " + assemblyLineNumber + ":");

            Calendar morningTimeVariable = DateUtils.createNewDateWithHourMinuteAndSecond(-3, 0, 0);
            Calendar startLunchTime = DateUtils.createNewDateWithHourMinuteAndSecond(0, 0, 0);
            Calendar afternoonTimeVariable = DateUtils.createNewDateWithHourMinuteAndSecond(1, 0, 0);
            Calendar finishAfternoonTime = DateUtils.createNewDateWithHourMinuteAndSecond(5, 0, 0);
            Calendar minimumTimeToLaborGym = DateUtils.createNewDateWithHourMinuteAndSecond(4, 0, 0);

            ApplicationUtils.setUpMorningAssemblyLine(productionStepsListOrdened, morningTimeVariable, startLunchTime);
            ApplicationUtils.setUpAfternoonAssemblyLine(productionStepsListOrdened, afternoonTimeVariable, finishAfternoonTime);
            ApplicationUtils.setUpLaborGynasticTime(afternoonTimeVariable, minimumTimeToLaborGym);

            assemblyLineNumber++;
            System.out.println("");

        }while (productionStepsListOrdened.size() != 0);
    }


}
