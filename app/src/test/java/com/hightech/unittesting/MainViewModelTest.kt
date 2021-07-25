package com.hightech.unittesting

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var model: Model

    private val length = 10.0
    private val width = 10.0
    private val expectedResult = 100.0

    @Test
    fun `calculate data`() {

        // given
        model = Model()
        mainViewModel = MainViewModel(model)

        // when
        mainViewModel.saveData(length, width)
        val actualResult = mainViewModel.getData()

        // then
        assertEquals(expectedResult, actualResult)
    }

}