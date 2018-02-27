package com.wineyard.winery.tools;

import com.wineyard.winery.entity.Wine;

import java.util.List;

public class HTMLBuilder {

    private static final String HTMLStart =
            "<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<title>Winery</title>" +
                    "</head>" +
                    "<body>";

    private static final String HTMLEnd = "<h3><a href=\"/\">Home</a></h3>" +
            "</body>" +
            "</html>";

    private static String addWine(Wine wine) {
        String name = wine.getName();
        String brand = wine.getBrand().getBrand();
        String colour = "N/A";
        String taste = "N/A";

        try
        {
            taste = wine.getTaste().getTaste();
        } catch (NullPointerException e) {}

        try
        {
            colour = wine.getColour().getColour();
        } catch (NullPointerException e) {}

        return String.format("<p><b>%s</b> %s : %s, %s", brand, name, colour, taste);
    }

    public static String getWinesHTML(List<Wine> winesList)
    {
        StringBuffer html = new StringBuffer();
        html.append(HTMLStart.toString());
        if(winesList.size() > 1)
        {
            for(Wine wine : winesList)
            {
                html.append(addWine(wine));
            }
        }
        else
        {
            html.append("<p>No wine of this type!</p>");
        }

        html.append(HTMLEnd);
        return html.toString();
    }

    public static String getError()
    {
        StringBuffer html = new StringBuffer();
        html.append(HTMLStart);
        html.append("<h2>Something went wrong!</h2>");
        html.append(HTMLEnd);
        return html.toString();
    }

    public static String getNoWine()
    {
        StringBuffer html = new StringBuffer();
        html.append(HTMLStart);
        html.append("<h2>No wine of such type!</h2>");
        html.append(HTMLEnd);
        return html.toString();
    }

}
