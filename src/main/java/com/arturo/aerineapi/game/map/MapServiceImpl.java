package com.arturo.aerineapi.game.map;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private MapRepository mapRepository;

	@Override
	public Map generateNewMap() {
		Integer numberLayers = 25;
		
		Map map = new Map();
		List<MapLayer> layers = new ArrayList<MapLayer>();
		
		
		for (int i = 0; i < numberLayers; i++) {
			MapLayer layer = new MapLayer();
			List<MapCoordinates> coords = new ArrayList<MapCoordinates>();
			
			for (int y = 0; y < 40; y++) {
				int maxX = y % 2 == 0 ? 7 : 6;
				for (int x = 0; x < maxX; x++) {
					coords.add(MapCoordinates.builder().x(x).y(y).build());
				}
			}
			
			layer.setCoordinates(coords);
			layers.add(layer);
		}
		
		map.setLayers(layers);
		
		return mapRepository.save(map);
	}
	
}
