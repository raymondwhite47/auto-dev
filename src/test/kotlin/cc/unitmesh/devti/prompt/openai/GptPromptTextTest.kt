package cc.unitmesh.devti.prompt.openai

import cc.unitmesh.devti.kanban.SimpleProjectInfo
import org.junit.Assert.assertEquals
import org.junit.Test

class GptPromptTextTest {

    @Test
    fun should_fill_story_detail() {
        val gptPromptText = GptPromptText()
        val projectInfo = SimpleProjectInfo("", "DevTi", "description")
        val story = "story information"

        val result = gptPromptText.fillStoryDetail(projectInfo, story)
        assertEquals("""你是一个敏捷项目的 BA，请根据如下的信息，编写用户故事。

1. 你的项目是：### DevTi:description ###
2. 你的需求是： ### story information ###。
3. 必须要考虑、尽可能考虑各种异常场景，添加更多的 AC（至少 3 个）。
4. 你的返回模板如下所示：

###
用户故事：可以选择宝贝出行服务
作为 xxx
我想 在xx出行的手机客户端里选择宝贝出行服务
以便于 我能够带宝宝打车出行的时候打到有儿童座椅的车

AC 1:  xxx
假设 xxx
当 xxx
于是 xxx
###
""", result)
    }
}