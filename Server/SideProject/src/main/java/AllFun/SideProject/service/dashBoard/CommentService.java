package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.dashBoard.Comment;
import AllFun.SideProject.domain.dashBoard.GroupBoard;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.dashBoard.groupBoard.CommentListDto;
import AllFun.SideProject.repository.dashBoard.CommentRepository;
import AllFun.SideProject.repository.dashBoard.GroupBoardRepository;
import AllFun.SideProject.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final GroupBoardRepository groupBoardRepository;
    private final MemberRepository memberRepository;

    public List<CommentListDto> getCommentList(Long groupBoardId){
        GroupBoard groupBoard = groupBoardRepository.findById(groupBoardId).orElse(null);
        List<Comment> comments = commentRepository.findAllByGroupBoardOrderByCreatedDateDesc(groupBoard).orElse(null);
        List<CommentListDto> response = new ArrayList<>();
        for (Comment comment : comments) {
            response.add(new CommentListDto(
                    comment.getId(),
                    comment.getMember().getNickname(),
                    comment.getComment(),
                    comment.getCreatedDate()
            ));
        }
        return response;
    }

    @Transactional
    public void createComment(Long groupBoardId, Long memberId, String request){
        GroupBoard groupBoard = groupBoardRepository.findById(groupBoardId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);
        Comment comment = Comment.createComment(member, request);
        groupBoard.addComment(comment);
        commentRepository.save(comment);
    }

    @Transactional
    public void editComment(Long commentId,String request){
        Comment comment = commentRepository.findById(commentId).orElse(null);
        comment.setComment(request);
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElse(null);
        commentRepository.delete(comment);
    }
}
