package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.matching.EntryPool;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.repository.matching.EntryPoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EntryPoolService {
    private final EntryPoolRepository entryPoolRepository;

    /**
     * create entry pool
     * @param entryPool
     */
    @Transactional
    public void save(EntryPool entryPool){
        entryPoolRepository.save(entryPool);
    }
}
