package yomankum.kafka.producer.yomankum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import yomankum.kafka.producer.yomankum.api.dto.AccountBookCreateNotice;
import yomankum.kafka.producer.yomankum.api.dto.AccountBookInputNotice;
import yomankum.kafka.producer.yomankum.api.dto.AccountBookUpdateNotice;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendAccountBookCreateNotice(AccountBookCreateNotice notice) {
        kafkaTemplate.send("create", notice);
        log.info("AccountBook 레코드 추가 알림 - accountBookId : {}", notice.accountBookId());
    }

    public void sendAccountBookInputNotice(AccountBookInputNotice notice) {
        kafkaTemplate.send("input", notice);
        log.info("AccountBook 레코드 쓰기 알림 - accountBookId : {}", notice.accountBookId());
    }

    public void sendUpdateNotice(AccountBookUpdateNotice notice) {
        kafkaTemplate.send("update", notice);
        log.info("AccountBook 레코드 수정 알림 - accountBookId : {}", notice.accountBookId());
    }
}
