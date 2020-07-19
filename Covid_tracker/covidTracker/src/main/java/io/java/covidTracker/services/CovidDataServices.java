package io.java.covidTracker.services;

import io.java.covidTracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataServices {

    private static String Covid_url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";

    private static String Death_url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_US.csv";

    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *") //schedule to update
    public void fetchCovidData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Covid_url))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());


        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);





        for (CSVRecord record : records) {
            LocationStats locationStats = new LocationStats();
            locationStats.setCounty(record.get("Admin2"));
            locationStats.setState(record.get("Province_State"));
            int latestCases = Integer.parseInt(record.get(record.size() -  1));
            int previousCases = Integer.parseInt(record.get(record.size() -  2));
            locationStats.setLatestCases(latestCases);
            locationStats.setNewCases(latestCases - previousCases);

            newStats.add(locationStats);
        }
        this.allStats = newStats;


    }

}
