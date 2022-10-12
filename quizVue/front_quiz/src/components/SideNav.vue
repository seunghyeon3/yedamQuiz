<template>
  <div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
      <div class="sb-sidenav-menu">
        <div class="nav">
          <div class="sb-sidenav-menu-heading">기초자료</div>
          <router-link class="nav-link" to="/">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> home
          </router-link>
          <router-link class="nav-link" to="/about">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> about
          </router-link>
          <router-link class="nav-link" to="codeList">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> 코드관리
          </router-link>

          <router-link class="nav-link" to="/registerCourse">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> 과정등록
          </router-link>
          <router-link class="nav-link" to="stdList">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> 학생관리
          </router-link>

          <div class="sb-sidenav-menu-heading">문제은행</div>
          <router-link class="nav-link" to="/quizReg">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> 문제등록
          </router-link>
          <router-link class="nav-link" to="/quizList">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> 문제관리
          </router-link>

          <div class="sb-sidenav-menu-heading">시험지관리</div>
          <router-link class="nav-link" to="/examRegistForm">
            <div class="sb-nav-link-icon">
              <i class="fas fa-tachometer-alt"></i>
            </div> 시험지등록
          </router-link>
            <router-link class="nav-link" to="examList">
              <div class="sb-nav-link-icon">
                <i class="fas fa-tachometer-alt"></i>
              </div> 시험지관리
            </router-link>

            <div class="sb-sidenav-menu-heading">통계관리</div>
            <router-link class="nav-link" to="/staticsByQuiz">
              <div class="sb-nav-link-icon">
                <i class="fas fa-tachometer-alt"></i>
              </div> 문제별 통계 메인
            </router-link>
            <router-link class="nav-link" to="/quizList">
              <div class="sb-nav-link-icon">
                <i class="fas fa-tachometer-alt"></i>
              </div> 문제별 통계 상세
            </router-link>

            <router-link class="nav-link collapsed" to="#" data-bs-toggle="collapse" data-bs-target="#collapsePages"
              aria-expanded="false" aria-controls="collapsePages">
              <div class="sb-nav-link-icon">
                <i class="fas fa-book-open"></i>
              </div> Pages
              <div class="sb-sidenav-collapse-arrow">
                <i class="fas fa-angle-down"></i>
              </div>
            </router-link>
            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth"
                  aria-expanded="false" aria-controls="pagesCollapseAuth"> Authentication
                  <div class="sb-sidenav-collapse-arrow">
                    <i class="fas fa-angle-down"></i>
                  </div>
                </a>
                <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne"
                  data-bs-parent="#sidenavAccordionPages">
                  <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="login.html">Login</a> <a class="nav-link"
                      href="register.html">Register</a>
                    <a class="nav-link" href="password.html">Forgot Password</a>
                  </nav>
                </div>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError"
                  aria-expanded="false" aria-controls="pagesCollapseError"> Error
                  <div class="sb-sidenav-collapse-arrow">
                    <i class="fas fa-angle-down"></i>
                  </div>
                </a>
                <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne"
                  data-bs-parent="#sidenavAccordionPages">
                  <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="401.html">401 Page</a> <a class="nav-link" href="404.html">404 Page</a> <a
                      class="nav-link" href="500.html">500 Page</a>
                  </nav>
                </div>
              </nav>
            </div>
        </div>

      </div>
      <div class="sb-sidenav-footer">
        <div class="small">Logged in as:</div>
        Start Bootstrap
      </div>
    </nav>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>
