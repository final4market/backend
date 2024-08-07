package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.MemberAddressDTO;
import com.market.dto.MemberDTO;
import com.market.dto.SellerPageProfileDTO;
import com.market.dto.SellerPageReceivedReviewDTO;
import com.market.dto.StoreDTO;
import com.market.service.MemberService;
import com.market.dto.MyPageFollowListDTO;
import com.market.dto.MyPageReceivedReviewDTO;
import com.market.dto.SellerPageFollowListDTO;
import com.market.dto.SellerPageProfileDTO;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/admin/allMembers")
    public ResponseEntity<List<MemberDTO>> selectAllMembers() {
        List<MemberDTO> members = memberService.selectAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/admin/searchMembers")
    public ResponseEntity<List<MemberDTO>> searchMembers(@RequestParam Map<String, String> params) {
        List<MemberDTO> members = memberService.searchMembers(params);
        return ResponseEntity.ok(members);
    }

    @PutMapping("/admin/updateMember")
    public ResponseEntity<Map<String, Object>> updateMember(@RequestBody MemberDTO dto) {
        int count = memberService.updateMember(dto);        
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("msg", count == 0 ? "회원정보 수정 실패" : "회원정보 수정 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/admin/deleteMember/{memberId}")
    public ResponseEntity<Map<String, Object>> deleteMember(@PathVariable String memberId) {
        int count = memberService.deleteMember(memberId);
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("msg", count == 0 ? "회원정보 삭제 실패" : "회원정보 삭제 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    @GetMapping("/admin/adminNickname/{memberId}")
    public ResponseEntity<Map<String, String>> getMemberNickname(@PathVariable String memberId) {
    	System.out.println("가져온 아이디: " + memberId);
        try {
            String memberNick = memberService.getAdminNickname(memberId);
            Map<String, String> response = new HashMap<>();
            response.put("memberNick", memberNick);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/api/member/storeInfo")
    public List<StoreDTO> storeInfo(@RequestParam("memberId") String memberId) {
        List<StoreDTO> list = memberService.storeInfo(memberId);
        return list;
    }

    @GetMapping("/api/member/sellerProfile")
    public String sellerProfile(@RequestParam("memberId") String memberId) {
        int profileNo = memberService.profileNo(memberId);
        String profilePath = memberService.profilePath(profileNo);
        return profilePath;
    }

    @PostMapping("/api/member/buyerProfile")
    public List<Map<String, Object>> buyerProfile(@RequestBody Map<String, Object> memberId) {
        List<String> buyerIds = (List<String>) memberId.get("memberId");
        List<String> buyerProfileNo = memberService.buyerProfileNo(buyerIds);
        List<Map<String, Object>> buyerProfilePath = memberService.buyerProfilePath(buyerProfileNo);
        return buyerProfilePath;
    }

    @GetMapping("/insertFollow")
    public Map<String, Object> insertFollow(@RequestParam("buyerId") String buyerId, @RequestParam("sellerId") String sellerId) {
        Map<String, Object> map = new HashMap<>();
        try {
            memberService.insertFollow(buyerId, sellerId);
            map.put("msg", "팔로우를 하셨습니다");
        } catch (Exception e) {
            memberService.deleteFollow(buyerId, sellerId);
            map.put("msg", "팔로우를 취소하셨습니다");
            return map;
        }
        return map;
    }

    @GetMapping("/addressInfo")
    public List<MemberAddressDTO> selectMemberAddress(@RequestParam("memberId") String memberId) {
        List<MemberAddressDTO> list = memberService.selectMemberAddress(memberId);
        return list;
    }

    @PostMapping("/insertMemberAddress")
    public Map<String, Object> insertMemberAddress(@RequestBody MemberAddressDTO dto) {
        Map<String, Object> map = new HashMap<>();
        int addressNo = memberService.currentAddressNO();
        dto.setMemberAddressNo(addressNo);
        try {
            memberService.insertMemberAddress(dto);
            map.put("msg", "등록되었습니다");
            return map;
        } catch (Exception e) {
            map.put("msg", "3개까지만 추가 하실 수 있습니다");
            return map;
        }
    }

    @DeleteMapping("/deleteMemberAddress")
    public Map<String, Object> deleteMemberAddress(@RequestParam("memberAddressNo") int memberAddressNo) {
        Map<String, Object> map = new HashMap<>();
        try {
            memberService.deleteMemberAddress(memberAddressNo);
            map.put("msg", "삭제되었습니다");
            return map;
        } catch (Exception e) {
            map.put("msg", "삭제실패했습니다");
            return map;
        }
    }

    @PutMapping("/changeMainAddress")
    public Map<String, Object> changeMainAddress(@RequestBody MemberAddressDTO dto) {
        Map<String, Object> map = new HashMap<>();
        try {
            memberService.changeMainAddressExisting(dto);
            memberService.changeMainAddressNew(dto);
            map.put("msg", "배송지가 수정되었습니다");
            return map;
        } catch (Exception e) {
            map.put("msg", "배송지 수정에 실패했습니다");
            return map;
        }
    }

    @GetMapping("/api/member/selectFollowStatus")
    public List<String> selectFollowStatus(@RequestParam("memberId") String memberId) {
        List<String> list = memberService.selectFollowStatus(memberId);
        return list;
    }
    
    @GetMapping("/api/member/sellerPageProfile/{sellerId}")
	public List<SellerPageProfileDTO> sellerPageProfile(@PathVariable String sellerId) {
		return memberService.sellerPageProfile(sellerId);
	}

	@GetMapping("/api/member/sellerPageReceivedReview/{sellerId}")
	public List<SellerPageReceivedReviewDTO> sellerPageReceivedReview(@PathVariable String sellerId) {
		return memberService.sellerPageReceivedReview(sellerId);
	}

	@GetMapping("/api/member/sellerPageFollowList/{sellerId}")
	public List<SellerPageFollowListDTO> sellerPageFollowList(@PathVariable String sellerId) {
		return memberService.sellerPageFollowList(sellerId);
	}
}