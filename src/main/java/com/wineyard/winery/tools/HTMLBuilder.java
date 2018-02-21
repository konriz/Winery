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

    private static final String HTMLEnd = "<h3><a href=\"/\">Go back!</a></h3>" +
            "</body>" +
            "</html>";

    private static String addElement(Wine wine) {
        String name = wine.getName();
        String colour = "N/A";
        String taste = "N/A";

        try
        {
            taste = wine.getTasteID().name();
        } catch (NullPointerException e) {}

        try
        {
            colour = wine.getColourID().name();
        } catch (NullPointerException e) {}

        return String.format("<p>%s : %s, %s", name, colour, taste);
    }

    public static String getHTML(List<Wine> winesList)
    {
        String html = HTMLStart;
        if(winesList.size() > 1)
        {
            for(Wine wine : winesList)
            {
                html += addElement(wine);
            }
        }
        else
        {
            html += "<p>No wine of this type!</p>";
        }

        html += HTMLEnd;
        return html;
    }
}
