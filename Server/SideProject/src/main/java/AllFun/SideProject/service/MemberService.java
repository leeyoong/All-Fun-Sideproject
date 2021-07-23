package AllFun.SideProject.service;

import AllFun.SideProject.repository.SpringDataJpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    @Autowired
    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;

}
