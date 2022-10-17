<template>
  <main>
    <div class='container-fluid px-4'>
      <!--  페이지 타이틀 -->
      <h1 class='mt-4'>문제은행 </h1>

      <!-- breadcrump / 도움말 -->
      <ol class='breadcrumb mb-4'>
        <li><a class='float-right' data-bs-toggle='collapse' href='#collapseHelp' role='button' aria-expanded='false'
            aria-controls='collapseHelp'>
            <img src='@/assets/img/free-icon-help-6269920.png' width='20px'></a></li>
        <li class='breadcrumb-item'><a href='index.html'>문제은행</a></li>
        <li class='breadcrumb-item active'>문제조회</li>
      </ol>

      <!--  페이지 도움말 시작 -->
      <div class='collapse  g-3 mb-2' id='collapseHelp'>
        <div class='card card-body'>문제은행관리는.<br>. <br>. <br>.</div>
      </div>
      <!--  페이지 도움말 종료 -->

      <div class='card mb-4'>
        <!--  검색 폼 시작 -->
        <!-- <i class='fas fa-table me-1'></i> -->
        <div class='card-header'>
          <form name='frmSearch' id='frmSearch'>
            <input type='hidden' name='page' value='1'>
            <div class='row g-3'>
              <!-- 문제 유형 -->
              <label for='typCd' class='col-sm-1 col-form-label text-end'>문제유형</label>
              <div class='col-sm-3'>
                <div class='form-check form-check-inline'>
                  <input class='form-check-input' name='typCd' type='radio'>
                  <label class='form-check-label' for='typCd'>전체</label>
                </div>
                <div v-for='code in codes.TYP' :key='code.cd' class='form-check form-check-inline'>
                  <input class='form-check-input' name='typCd' type='radio' :value='code.cd'>
                  <label class='form-check-label' for='typCd'>{{code.nm}}</label>
                </div>
              </div>
              <!-- 과목 -->
              <label for='sbjtCd' class='col-sm-1 col-form-label text-end'>과목</label>
              <div class='col-sm-3'>
                <select class='form-select' aria-label='Default select example' v-model="quizVO.sbjtCd">
                  <option selected value=''>과목선택</option>
                  <option v-for='code in codes.SBJT' :key='code.cd' :value='code.cd'>{{code.nm}}</option>
                </select>
              </div>
            </div>
            <div class='row g-3'>
              <label for='useYn' class='col-sm-1 col-form-label text-end'>사용여부</label>
              <div class='col-sm-3'>
                <div class='form-check form-switch'>
                  <input class='form-check-input' type='checkbox' role='switch' id='flexSwitchCheckChecked' name='useYn'
                    value='Y' checked>
                </div>
              </div>
              <label for='quizCtnt' class='col-sm-1 col-form-label text-end'>문제</label>
              <div class='col-sm-3'>
                <input type='text' id='quizCtnt' name='quizCtnt' class='form-control' placeholder='내용'
                  v-model="quizVO.quizCtnt">
              </div>
            </div>
            <div class='row g-3 justify-content-end'>
              <div class='btn-group col-sm-3' role='group'>
                <button type='button' class='btn btn-primary' id='btnSearch' @click="getList">검색</button>
                <button type='button' class='btn btn-warning' id='btnInit'>초기화</button>
              </div>
            </div>
          </form>
        </div>
        <!--  검색폼 종료 -->
        <input :value="userno">
        <!--  문제 목록 시작 -->
        <div class='card-body'>
          <!--  버튼 그룹 시작 -->
          <div class='g-3 text-end'>
            <button type='button' class='btn btn-outline-primary' id='btnOptDel'>선택삭제</button>
            <button type='button' class='btn btn-outline-primary' id='btnOptUse' @click='optUseProc(1)'>선택사용</button>
            <button type='button' class='btn btn-outline-primary' id='btnOptNoUse' @click='optUseProc(0)'>선택미사용</button>
            <button type='button' class='btn btn-outline-primary' id='btnExcelDown'>엑셀다운로드</button>
            <button type='button' class='btn btn-outline-primary' id='btnReg'>개별등록</button>
            <button type='button' class='btn btn-outline-primary' id='btnBatchReg'>일괄등록</button>
          </div>
          <!--  버튼 그룹 종료 -->

          <form id='frmList' name='frmList'>
            <table class='table'>
              <thead>
                <tr>
                  <th><input type="checkbox" @click="checkedAll($event.target.checked)"></th>
                  <th>번호</th>
                  <th>과목</th>
                  <th>문제유형</th>
                  <th>문제명</th>
                  <th>등록일</th>
                  <th>사용여부</th>
                  <th>출제수</th>
                  <th>정답율</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for='(quiz, index) in quizList' :key='quiz.quizNo'>
                  <td><input type='checkbox' name='quizNo' :value='quiz.quizNo' v-model="checkedList"></td>
                  <td>{{quiz.quizNo}}</td>
                  <td>{{quiz.sbjtNm}}</td>
                  <td>{{quiz.typNm}}</td>
                  <td class='ctnt' onclick=''>{{quiz.quizCtn}}</td>
                  <td>{{quiz.regDt | yyyyMMdd}}</td>
                  <td>{{quiz.useYn}}</td>
                  <td>{{quiz.questCnt}}</td>
                  <td>{{quiz.rightRate}}</td>
                </tr>
              </tbody>
            </table>
          </form>
        </div>
      </div>
      <!--  문제 목록 종료 -->
    </div>
  </main>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      userno: '',
      codes: {},
      quizList: [],
      quizVO: { sbjtCd: '', quizCtnt: '' },
      checkedList: []
    }
  },
  mounted() {
    this.getList()
    this.userno = this.$session.get('user_no')
  },
  watch: {
    usernoW() {
      this.userno = this.$session.get('user_no')
    }
  },
  methods: {
    async getList() {
      const response = await axios.get('http://localhost:85/quizList', { params: this.quizVO })
      this.codes = response.data.codes
      this.quizList = response.data.quizList
      if (response.data.quizVO) {
        this.quizVO = response.data.quizVO
      }
    },
    optUseProc(useYn) {
      if (this.checkedList.length === 0) {
        alert('선택')
        return
      }
      axios({
        method: 'post',
        url: 'http://localhost:85/quizUpdateUseYn',
        data: JSON.stringify({ quizNo: this.checkedList, useYn: useYn }),
        headers: {
          'Content-Type': 'application/json; charset=utf-8'
        }
      }).then(res => {
        this.getList()
      })
    },
    checkedAll(checked) {
      const checkedList = []
      if (checked) {
        for (const quiz of this.quizList) {
          checkedList.push(quiz.quizNo)
        }
      }
      this.checkedList = checkedList
    }
  }
}
</script>

<style>

</style>
