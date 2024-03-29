package com.guimaraes.controller;

import java.util.ArrayList;
import java.util.List;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.track.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.constant.AppConstants;
import com.netflix.discovery.EurekaClient;

@RestController
public class ArtistController {

	private static final String RESOURCE_NAME = "/artist";
	private static final String CONTEXT_RESOURCE = "/" + AppConstants.VERSION_V1 + RESOURCE_NAME;

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping(CONTEXT_RESOURCE)
	public List<Track> getArtistByFilters(@RequestParam("artistName") String artistName) {

		MusixMatch musixMatch = new MusixMatch(AppConstants.MUSICX_MATCH_API_KEY);
		try {
			return musixMatch.searchTracks("", artistName, "", 1, 100, true);
		} catch (MusixMatchException e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

}
