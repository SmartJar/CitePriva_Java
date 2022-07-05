package es.license.citapriva.utils;


import es.license.citapriva.model.CountriesModel;
import es.license.citapriva.model.SedeInfo;

import java.util.ArrayList;
import java.util.List;


public class Constants {

    public static final String jsonURL = "https://cita.smartjar.dev/data.json";
    public static final String dataFolderUrl = "https://cita.smartjar.dev/data/";
    public static final String URL1 = "https://sedeclave.dgt.gob.es/WEB_NCIT_CONSULTA/solicitarCitaPaso2.faces";
    public static final String URL2 = "https://sedeclave.dgt.gob.es/WEB_NCIT_CONSULTA/solicitarCitaPaso3.faces";
    public static final String noAppointmentMsg = "El horario de atención al cliente está completo para los próximos días. Inténtelo más tarde";

    public static int dataFetched = 0;
    public static List<String> userAgents = new ArrayList<>();
    public static List<CountriesModel> countriesModelList = new ArrayList<>();
    public static List<SedeInfo> sedeInfos = new ArrayList<>();
    public static SedeInfo currentSedInfo = new SedeInfo();
}
