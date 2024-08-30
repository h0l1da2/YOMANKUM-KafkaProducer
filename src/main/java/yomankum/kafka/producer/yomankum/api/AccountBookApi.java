package yomankum.kafka.producer.yomankum.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yomankum.kafka.producer.yomankum.api.dto.AccountBookCreateNotice;
import yomankum.kafka.producer.yomankum.api.dto.AccountBookInputNotice;
import yomankum.kafka.producer.yomankum.service.NoticeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account-book")
public class AccountBookApi {

    private final NoticeService noticeService;

    @PostMapping("/create")
    public void sendAccountBookCreateNotice(@RequestBody AccountBookCreateNotice notice) {
        noticeService.sendAccountBookCreateNotice(notice);
    }

    @PostMapping("/input")
    public void sendAccountBookInputNotice(@RequestBody AccountBookInputNotice notice) {
        noticeService.sendAccountBookInputNotice(notice);
    }

}
