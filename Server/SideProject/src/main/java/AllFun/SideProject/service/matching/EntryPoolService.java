package AllFun.SideProject.service.matching;

import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.EntryPool;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.repository.matching.EntryPoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * delete entry pool
     * @param board
     * @param member
     * @param role
     * @return
     */
    @Transactional
    public String deleteEntryPool(Board board, Member member, String role){
        EntryPool entryPool = entryPoolRepository.findByBoardAndMemberAndRole(board, member, role).orElse(null);
        if (entryPool == null){
            return null;
        }
        entryPoolRepository.delete(entryPool);
        return "ok";
    }

    public List<EntryPool> findAllByBoardAndRole(Board board, String role){
        return entryPoolRepository.findAllByBoardAndRole(board, role).orElse(null);
    }

}
