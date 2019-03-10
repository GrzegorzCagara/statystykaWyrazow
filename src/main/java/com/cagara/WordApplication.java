package com.cagara;

import com.cagara.dto.Statistics;
import com.cagara.service.TextService;
import com.cagara.service.TextServiceImpl;
import com.cagara.service.WordStatisticService;
import com.cagara.service.WordStatisticServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WordApplication {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String content = restTemplate.getForObject("http://www.gutenberg.org/files/1342/1342-0.txt", String.class);

		TextService textService = new TextServiceImpl();
		WordStatisticService wordStatisticService = new WordStatisticServiceImpl(textService);

		Statistics statistics = wordStatisticService.calculateStatistics(content);
		statistics.printStatistics();
	}


}
