package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {
// @Ignore("dlaczego ignorujemy")
    @Test
    fun getActiveAndCompletedStats_oneNotCompletedTask_returnsHundredZero() {
        // when - warunki początkowe -> lista zadań
        val tasks = listOf<Task>(
                Task("test", "test", false)
        )
        // given - wywołanie funkcji
        val result = getActiveAndCompletedStats(tasks)
        // then - czy rezultat zwrócony zgadza się z oczekiwanym
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_oneCompletedTask_returnsZeroHundred() {
        val tasks = listOf<Task>(
                Task("test", "test", true)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.activeTasksPercent)
        assertEquals(100f, result.completedTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedTasks_threeNotCompletedTasks_returnsSixtyFourty() {
        val tasks = listOf<Task>(
                Task("test", "test", true),
                Task("test", "test", true),
                Task("test", "test", false),
                Task("test", "test", false),
                Task("test", "test", false)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(60f, result.activeTasksPercent)
        assertEquals(40f, result.completedTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnsZeroZero() {

        val result = getActiveAndCompletedStats(emptyList())
        assertEquals(0f, result.activeTasksPercent)
        assertEquals(0f, result.completedTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZeroZero() {

        val result = getActiveAndCompletedStats(null)
        assertEquals(0f, result.activeTasksPercent)
        assertEquals(0f, result.completedTasksPercent)
    }

}