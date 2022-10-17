import QuizListView from '../views/quiz/QuizListView.vue'
import QuizRegView from '../views/quiz/QuizRegView.vue'

export default [
  {
    path: '/quizList',
    name: 'quizList',
    component: QuizListView
  },
  {
    path: '/quizReg',
    name: 'quizReg',
    component: QuizRegView
  }
]
