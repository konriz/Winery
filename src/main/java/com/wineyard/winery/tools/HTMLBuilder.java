package com.wineyard.winery.tools;

import com.wineyard.winery.entity.Wine;
import com.wineyard.winery.entity.WineDTO;

import java.util.List;

public class HTMLBuilder {

    private static String HTMLHeader = "<!DOCTYPE html>" +
            "<html lang=\"en\">" +
            "<head>" +
            "<meta charset=\"UTF-8\">" +
            "<title>Winery</title>" +
            "</head>" +
            "<body>";


    private static String HTMLStart(String wineCategory)
    {
        StringBuilder start = new StringBuilder();
        start.append(
                String.format("<!DOCTYPE html>" +
                        "<html lang=\"en\">" +
                        "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<title>Winery - %1$s wines</title>" +
                        "</head>" +
                        "<body>" +
                        "<h2>-- %1$s wines --</h2>",
                        wineCategory.substring(0,1).toUpperCase() + wineCategory.substring(1))
        );
        return start.toString();
    }

    private static final String HTMLEnd = "<h3><a href=\"/\">Home</a></h3>" +
            "</body>" +
            "</html>";

    private static String addWine(WineDTO wine) {
        String name = wine.getName();
        String brand = wine.getBrand();
        String colour = "N/A";
        String taste = "N/A";

        try
        {
            taste = wine.getTaste();
        } catch (NullPointerException e) {}

        try
        {
            colour = wine.getColour();
        } catch (NullPointerException e) {}

        return String.format("<p><b>%s</b> %s : %s, %s", brand, name, colour, taste);
    }

    public static String getWinesHTML(String wineCategory, List<WineDTO> winesList)
    {
        StringBuilder html = new StringBuilder();
        html.append(HTMLStart(wineCategory));
        if(winesList.size() > 1)
        {
            for(WineDTO wine : winesList)
            {
                html.append(addWine(wine));
            }
        }
        else
        {
            html.append(getNoWine());
        }

        html.append(HTMLEnd);
        return html.toString();
    }

    public static String getError()
    {
        StringBuilder html = new StringBuilder();
        html.append(HTMLHeader);
        html.append("<h2>Something went wrong!</h2>");
        html.append(HTMLEnd);
        return html.toString();
    }

    public static String getNoWine()
    {
        StringBuilder html = new StringBuilder();
        html.append(HTMLHeader);
        html.append("<h2>No wine of such type!</h2>");
        return html.toString();
    }

}
