package com.ag.rules

import com.ag.rules.MethodsIssue.Companion.ISSUE
import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

class MethodsDetector : Detector(), Detector.UastScanner {

//    private val methods = mutableListOf<List<UMethod>>()

//    override fun beforeCheckFile(context: Context) {
//        methods.clear()
//    }
//
//    override fun afterCheckFile(context: Context) {
//        methods.forEach { subList ->
//            var previewWeight = Int.MAX_VALUE
//            var previewMethod = subList[0]
//            subList.forEach { method ->
//
//                if(method.getWeight() > previewWeight)
//
//            }
//        }
//    }

    override fun getApplicableUastTypes(): List<Class<out UElement>>? =
        listOf(UClass::class.java)

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return MethodsVisitor(context)
    }

    inner class MethodsVisitor(private val context: JavaContext) : UElementHandler() {
        override fun visitClass(node: UClass) {
//            methods.add(node.methods.toList())

            val methods = node.methods
            var previewMethod = methods[0]

            methods.forEach { method ->
                if (method.getWeight() > previewMethod.getWeight()) {
                    report(context, method)
                }
                previewMethod = method
            }
        }

        private fun report(context: JavaContext, node: UElement) {
            context.report(
                ISSUE,
                node,
                context.getLocation(node),
                "Test"
            )
        }
    }
}