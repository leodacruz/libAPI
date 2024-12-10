package org.example.Report;

import io.qameta.allure.Allure.ThrowableRunnableVoid;

public class ReportGeneric {

    static ReportNome reportName;

    public static void setReport(ReportNome nome) {
        reportName = nome;
    }

    public static void descricaoTeste(String descricao) {

        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.description(descricao);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void donoTeste(String owner) {

        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.owner(owner);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }
    }

    public static void severidadeTeste(String severity) {

        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.severity(severity);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void linkTeste(String name, String url) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.link(name, url);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void linkTeste(String url) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.link(url);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void epicoTeste(String epic) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.epic(epic);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void featureTeste(String feature) {

        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.feature(feature);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void historiaTeste(String story) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.story(story);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void suiteTeste(String suite) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.suite(suite);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }
    }

    public static void parentSuiteTeste(String parentSuite) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.parentSuite(parentSuite);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }

    }

    public static void subSuiteTeste(String subSuite) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.subSuite(subSuite);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }
    }

    public static void step(String step) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.step(step);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }
    }

    public static void step(String step, ThrowableRunnableVoid runnable) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.step(step, runnable);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }
    }

    public static void parameter(String parameter, String value) {
        switch (reportName) {
            case ALLURE_REPORT:
                AllureReportGeneric.parameter(parameter, value);
                break;
            case EXTENT_REPORT:

                break;
            default:
                break;
        }
    }

    // Enum com o nome dos reports que podem ser gerados
    public enum ReportNome {

        ALLURE_REPORT,
        EXTENT_REPORT;

        public String getReportNome() {
            return this.name();
        }
    }

}
