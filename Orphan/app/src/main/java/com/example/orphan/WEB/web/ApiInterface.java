package com.example.orphan.WEB.web;



import com.example.orphan.WEB.DTO.dashBoard.group.MyGroupListDto;
import com.example.orphan.WEB.DTO.dashBoard.groupBoard.CommentListDto;
import com.example.orphan.WEB.DTO.dashBoard.groupBoard.CreateGroupBoardDto;
import com.example.orphan.WEB.DTO.dashBoard.groupBoard.EditGroupBoardDto;
import com.example.orphan.WEB.DTO.dashBoard.groupBoard.GroupBoardListDto;
import com.example.orphan.WEB.DTO.dashBoard.todo.CreateToDoDto;
import com.example.orphan.WEB.DTO.dashBoard.todo.EditToDoDto;
import com.example.orphan.WEB.DTO.dashBoard.todo.GroupToDoDto;
import com.example.orphan.WEB.DTO.mainPage.MyGroupBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyMatchingBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyMatchingStatusDto;
import com.example.orphan.WEB.DTO.mainPage.MyNoHitBoardDto;
import com.example.orphan.WEB.DTO.mainPage.MyScrapDto;
import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.DTO.matching.CreateBoardPossibleDto;
import com.example.orphan.WEB.DTO.matching.CreateBoardRequestDto;
import com.example.orphan.WEB.DTO.matching.EditBoardDto;
import com.example.orphan.WEB.DTO.matching.EntryPoolResponseDto;
import com.example.orphan.WEB.DTO.matching.ReadDetailDto;
import com.example.orphan.WEB.DTO.matching.SearchResponseDto;
import com.example.orphan.WEB.DTO.member.CreateMemberDto;
import com.example.orphan.WEB.DTO.member.FindPasswordDto;
import com.example.orphan.WEB.DTO.member.LoginDto;
import com.example.orphan.WEB.DTO.member.MemberInfoDto;
import com.example.orphan.WEB.DTO.member.MemberLoginDto;
import com.example.orphan.WEB.DTO.member.MyInfoDto;
import com.example.orphan.WEB.DTO.member.OneItemDto;
import com.example.orphan.WEB.DTO.note.MessageDto;
import com.example.orphan.WEB.DTO.note.NoteDataDto;
import com.example.orphan.WEB.helper.Page;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {



    @GET("/auth/check/email/{email}")
    Call<OneItemDto> emailCheck(@Path("email") String email);

    @GET("/auth/send/email")
    Call<OneItemDto> getEmailCODE(@Body OneItemDto Object);

    @GET("/auth/check/nickname")
    Call<OneItemDto> nickNameCheck(@Body OneItemDto Object);


    @POST("/auth/login")
    Call<MemberLoginDto> login(@Body LoginDto Object);


    //sign up
    @POST("/auth/create")
    Call<OneItemDto> createMember(@Body CreateMemberDto jsonObject);

    //이메일 찾기
    @GET("/auth/find/email/name/{name}/birth/{birth}/phone/{phone}")
    Call<OneItemDto> findID(@Path("name") String name, @Path("birth")String birth, @Path("phone")String phone);



    //send email
    @PATCH("/auth/find/password")
    Call<OneItemDto> findPW(@Body FindPasswordDto Object);


    String home= "/home";

    @GET ("home/{memberId}/todo/{year}/{month}")
    Call<List<MyToDoDto>> GetMytodo(@Path("memberId") Long memberid, @Path("year") String year, @Path("month") String month);
    // String인데 숫자


    @GET ("home/{memberId}/matching/board")
    Call<List<MyMatchingBoardDto>> matchigBoard(@Path("memberId") Long memberid);

    @GET ("home/{memberId}/matching/status")
    Call<List<MyMatchingStatusDto>> matchigStatus(@Path("memberId") Long memberid);


    @GET ("home/{memberId}/matching/scrap")
    Call<List<MyScrapDto>> matchigScrap(@Path("memberId") Long memberid);


    @GET ("home/{memberId}/group/board")
    Call<List<MyGroupBoardDto>> groupBoard(@Path("memberId") Long memberid);


    @GET ("home/{memberId}/group/board/no/hit")
    Call<List<MyNoHitBoardDto>> groupBoardNoHit(@Path("memberId") Long memberid);
    //이거 변동사항 .size


///////////my page


    @PATCH("/myPage/{memberId}/password")
    Call<String> myPage_PATCH_ModifyPassword(@Path("memberId") Long memberid);


    @GET("/myPage/my/{memberId}")
    Call<MyInfoDto> myPage_GET_Getmyinfo(@Path("memberId") Long memberid);

    @GET("/myPage/{memberId}/edit")
    Call<MemberInfoDto> myPage_GET_Editdata(@Path("memberId") Long memberid);

    @PATCH("/myPage/{memberId}/edit")
    Call<String> myPage_PATCH_Editdata(@Path("memberId") Long memberid);

/// note

    @GET("/note/list/{myId}")
    Call<List<NoteDataDto>> note_GET_myNoteList(@Path("myId") Long memberid);

    @GET("/note/list/{roomId}")
    Call<List<NoteDataDto>> note_GET_getUserIdList(@Path("roomId") Long roomid);

    @POST("/note/from/{myId}/to/{userId}")
    Call<List<NoteDataDto>> note_POST_sendNote(@Path("myId") Long myid, @Path("roomId") Long roomid, @Body MessageDto request);


//   대쉬보드 덧글 이건 작살나있음 양식


    @GET("/dashboard/{groupId}/board/{groupBoardId}/list")
    Call<List<CommentListDto>> dashboard_GET_getCommentList(@Path("groupId") Long groupId,@Path("groupBoardId") Long groupBoardId);


// ("/dashboard/{groupId}/board")


    @GET("/dashboard/{groupId}/board/list/notice")
    Call<GroupBoardListDto> board_GET_groupBoardNotice(@Path("groupId") Long groupId);

// 여기 미구현 시팔 개어렵네 (*이융 참조)
    @GET("/dashboard/{groupId}/board/list")
    Call<List<GroupBoardListDto>> board_GET_groupBoardList(@Path("groupId")Long groupId);



    @PATCH("/dashboard/{groupId}/board/list/{groupBoardId}/member/{memberId}")
    Call<GroupBoardListDto> board_PATCH_groupBoardDetail(@Path("groupId")Long groupId,
                                                         @Path("groupBoardId")Long groupBoardId,
                                                         @Path("memberId") Long memberId);




    @POST("/dashboard/{groupId}/board/create/{memberId}")
    Call<?> board_POST_createBoard(@Path("groupId")Long groupId, @Path("memberId") Long memberId,
                                    @Body CreateGroupBoardDto request);



    @GET("/dashboard/{groupId}/board/edit/{groupBoardId}")
    Call<EditGroupBoardDto> board_GET_editGroupBoard(@Path("groupId")Long groupId, @Path("groupBoardId") Long groupBoardId);



    @PATCH("/dashboard/{groupId}/board/edit")
    Call<?> board_POST_editGroupBoard(@Path("groupId")Long groupId,@Body EditGroupBoardDto request);

    @DELETE("/dashboard/{groupId}/board/delete/{groupBoardId}")
    Call<?> board_DELETE_deleteCalendar(@Path("groupId")Long groupId,@Path("groupBoardId")Long groupBoardId);

 /// GroupController  ("/dashboard")


    @GET("/dashboard/group/member/{memberId}")
    Call<List<MyGroupListDto>>   GroupController_GET_myGroup(@Path("memberId")Long memberId);

    @POST("/dashboard/group/member/{memberId}")
    Call<?>   GroupController_POST_createGroup(@Path("memberId") Long memberId,
                                               @Body String groupName);


    @DELETE("/dashboard/group/{groupId}")
    Call<?>   GroupController_DELETE_deleteGroup(@Path("groupId")Long groupId);

    @DELETE("/dashboard/group/{groupId}/member/{memberId}")
    Call<?>   GroupController_DELETE_deleteGroup(@Path("groupId")Long groupId ,
                                                 @Path("memberId")Long memberId);


// ToDoController  ("/dashboard/{groupId}/todo")

    @POST("/dashboard/{groupId}/todo/create")
    Call<?> ToDoController_POST_create(@Path("groupId")Long groupId, @Body CreateToDoDto request);



    @GET("/dashboard/{groupId}/todo/list/{year}/{month}")
    Call<List<GroupToDoDto>> ToDoController_GET_toDoList(@Path("groupId")Long groupId,
                                                         @Path("year")String year,
                                                         @Path("month")String month);


    @GET("/dashboard/{groupId}/todo/edit/{todoId}")
    Call<EditToDoDto> ToDoController_GET_getEditTodo(@Path("groupId")Long groupId,
                                                     @Path("todoId")Long todoId);

    @PATCH("/dashboard/{groupId}/todo/edit/{todoId}")
    Call<?> ToDoController_PATCH_editTodo(@Path("groupId")Long groupId,
                                                  @Path("todoId")Long todoId,
                                                  @Body EditToDoDto request);


    @DELETE("/dashboard/{groupId}/todo/delete/{todoId}")
    Call<?> ToDoController_DELETE_deleteTodo(@Path("groupId")Long groupId,
                                          @Path("todoId")Long todoId);





//MatchingBoardController  ("/board")


    @GET("/board/create/member/{memberId}")
    Call<List<CreateBoardPossibleDto>> MatchingBoardController_GET_createForm(@Path("memberId")Long memberId);
    // 두가지 경우이므로 신중히  204 생성 200 추가


    @POST("/board/create/group/{groupId}/member/{memberId}")
    Call<?> MatchingBoardController_POST_create(@Body CreateBoardRequestDto request,
                                               @Path("groupId") Long groupId,
                                               @Path("memberId") Long memberId);


    // 미구현
    @GET("/board/list/recently/filter/{filter}?page={page}")

    Call<Page<SearchResponseDto>> MatchingBoardController_GET_listRecently(@Path("page") int page,
                                                                            @Path("filter") String filter);



    @GET("/board/list/deadline/filter/{filter}")
    Call<Page<SearchResponseDto>> MatchingBoardController_GET_listDeadline(@Body Object obejct,
                                                                            @Path("filter") String filter);


    @GET("/board/search/title/{keyword}/recently/filter/{filter}")
    Call<Page<SearchResponseDto>> MatchingBoardController_GET_searchRecently(@Path("keyword")String keyword, @Path("filter")String filter,
                                                                                         @Body Object PageableDefault);



    @GET("/board/search/title/{keyword}/deadline/filter/{filter}")
    Call<Page<SearchResponseDto>> MatchingBoardController_GET_searchDeadline(@Path("keyword")String keyword, @Path("filter")String filter,
                                                                             @Body Object PageableDefault);




    @GET("/board/{boardId}/detail")
    Call<ReadDetailDto> MatchingBoardController_GET_readDetail(@Path("boardId") Long boardId);


    @GET("/board/edit/{boardId}")
    Call<ReadDetailDto> MatchingBoardController_GET_getEdit(@Path("boardId") Long boardId);


    @PATCH("/board/edit/{boardId}")
    Call<?> MatchingBoardController_PATCH_getEditedit(@Body EditBoardDto request, @Path("boardId") Long boardId);

    @PATCH("/board/edit/{boardId}/status")
    Call<?> MatchingBoardController_PATCH_changeStatus(@Path("boardId")Long boardId);

    @DELETE("/board/edit/{boardId}")
    Call<?> MatchingBoardController_DELETE_delete(@Path("boardId")Long boardId);

    @POST("/board/{boardId}/scrap/{memberId}")
    Call<?> MatchingBoardController_POST_scrapBoard(@Path("boardId")Long boardId,
                                                      @Path("memberId") Long memberId);

    @DELETE("/board/{boardId}/scrap/{memberId}")
    Call<?> MatchingBoardController_DELETE_deleteScrapBoard(@Path("boardId")Long boardId,
                                                    @Path("memberId") Long memberId);






// MatchingEntryController  ("/board")
    @POST("/board/{boardId}/role/{role}/member/{memberId}")
    Call<?>  MatchingEntryController_POST_clickEntry(@Path("boardId")Long boardId,
                                                     @Path("memberId")Long memberId,
                                                     @Path("role")String role);


    @DELETE("/board/{boardId}/role/{role}/member/{memberId}")
    Call<?>  MatchingEntryController_DELETE_cancelEntry(@Path("boardId")Long boardId,
                                                     @Path("memberId")Long memberId,
                                                     @Path("role")String role);




    @GET("/board/{boardId}/role/{role}")
    Call<List<EntryPoolResponseDto>>  MatchingEntryController_GET_checkEntry(@Path("boardId")Long boardId,
                                                                                @Path("role")String role);



    @PATCH("/board/{boardId}/role/{role}/member/{memberId}/status/{status}")
    Call<?>  MatchingEntryController_PATCH_resultEntry(@Path("boardId")Long boardId,
                                                                                @Path("role")String role,
                                                                                @Path("memberId")Long memberId,
                                                                                @Path("status")String status);




}
