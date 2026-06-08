package com.loginwebsite.websiteproject.util;

import com.filmdome.movies.entity.Movie;
import com.filmdome.movies.entity.Studio;
import com.loginwebsite.websiteproject.dto.MovieSearchDto;
import com.loginwebsite.websiteproject.dto.StudioDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudioUtil {

    public static Set<StudioDto> convertTo(Set<Studio> studios) {
        Set<StudioDto> studioDtoList = new HashSet<StudioDto>();

        for (Studio s: studios) {
            studioDtoList.add(convertTo(s));
        }

        return studioDtoList;
    }

    public static StudioDto convertTo(Studio s) {
        StudioDto studioDto = new StudioDto();
        studioDto.setName(s.getName());

        return studioDto;
    }
}
