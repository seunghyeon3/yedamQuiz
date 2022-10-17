<template>
  <main>
    <div class='container-fluid px-4'>
      <!--  페이지 타이틀 -->
      <h1 class="mt-4">문제등록</h1>

      <!--  페이지 도움말 시작 -->
      <div class="collapse  g-3 mb-2" id="collapseHelp">
        <div class="card card-body">문제은행관리는.<br>. <br>. <br>.</div>
      </div>
      <!--  페이지 도움말 종료 -->

      <!--  문제 등록 폼 시작 -->
      <form name="frmQuiz" id="frmQuiz" method="post">
        <!--  과목명    -->
        <div class="mb-3 row">
          <label for="sbjtCd" class="col-sm-2 col-form-label">과목명</label>
          <div class="col-sm-10">
            <select class="form-select" aria-label="Default select example" v-model="sbjtCd">
              <option selected value="">과목선택</option>
              <option v-for="code in codes.SBJT" :key="code.cd" :value="code.cd">{{code.nm}}</option>
            </select>
          </div>
        </div>

        <!--  문제      -->
        <div class="mb-3 row">
          <label for="quizCtnt" class="col-sm-2 col-form-label">문제</label>
          <div class="col-sm-10">
            <input type="text"  v-model="quizCtnt">
            <div id="quizCtntEditor"></div>
          </div>
        </div>

        <!--  문제해설    -->
        <div class="mb-3 row">
          <label for="desct" class="col-sm-2 col-form-label">문제해설</label>
          <div class="col-sm-10">
            <input type="text" v-model="desct">
            <div id="desctEditor"></div>
          </div>
        </div>

        <!--  사용여부    -->
        <div class="mb-3 row">
          <label for="useYn" class="col-sm-2 col-form-label">사용여부</label>
          <div class="col-sm-10">
            <div class="form-check form-switch">
              <input class="form-check-input" type="checkbox" role="switch" v-model="useYn"
                value="Y" checked>
            </div>
          </div>
        </div>

        <!--  문제유형   -->
        <div class="mb-3 row">
          <label for="typCd" class="col-sm-2 col-form-label">문제유형</label>
          <div class="col-sm-10">
              <div v-for="code in codes.TYP" :key="code.cd" class="form-check form-check-inline">
                <input class="form-check-input" v-model="typCd" type="radio" :value="code.cd">
                <label class="form-check-label" for="typCd">{{code.nm}}</label>
              </div>
          </div>
        </div>

        <!--  정답    -->
        <div class="mb-3 row ansr">
          <label for="ansr" class="col-sm-2 col-form-label">정답</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" v-model="ansr">
          </div>
        </div>

        <!--  문제 보기    -->
        <div class="mb-3 row sectionList">
          <div class="col-12">
            <button type="button" class="btnSectAdd btn btn-outline-success">보기 추가</button>
          </div>
          <div class="scetion row" v-for="(section,idx) in sections" :key="idx" >
            <label for="typCd" class="col-sm-2 col-form-label"><button type="button"
                class="btn btn-outline-primary btnSectDel">-</button> <input type="radio" name="ansrMulti"
                :value="idx+1"><span class="sectNum">{{idx+1}}</span></label>
            <div class="col-sm-10">
              <textarea rows="3" cols="60" v-model="section"></textarea>
            </div>
          </div>
        </div>
      </form>
      <!--  문제 등록 폼 종료 -->

      <!--  버튼 그룹 시작 -->
      <div>
        <!-- <div class="btn-group" role="group" aria-label="Basic example"> -->
        <button type="button" class="btn btn-success" id="btnSave">저장</button>
        <button type="button" class="btn btn-warning" id="btnSaveNew">저장 후 신규추가</button>
        <button type="button" class="btn btn-info" id="btnCopy">문제복제</button>
        <!-- </div> -->
        <div class="btn-group" role="group" aria-label="Basic example">
          <button type="button" class="btn btn-warning" id="btnList">목록</button>
          <button type="button" class="btn btn-primary" id="btnPreview">미리보기</button>
        </div>
      </div>
      <!--  버튼 그룹 종료 -->



    </div>
  </main>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      codes: {},
      quiz: {
        sbjtCd: '',
        quizCtnt:'',
        typCd:'',
        ansr:'',
        desct:'',
        useyn:''
      },
      sections: ['','','','']
    }
  },

  created () {
    axios.get('http://localhost:85/getCodes', {params : {codes: 'SBJT,TYP'}})
    .then((response)=>{
      this.codes = response.data
    })
  }
}
</script>

<style>

</style>