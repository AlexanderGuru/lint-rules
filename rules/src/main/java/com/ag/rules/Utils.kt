package com.ag.rules

import com.intellij.psi.PsiModifier
import org.jetbrains.uast.UField
import org.jetbrains.uast.UMethod

fun UMethod.getWeight(): Int {
    return when {
        isConstructor -> StatementType.CONSTRUCTOR
        isAbstract() -> StatementType.ABSTRACT_METHOD
        isOverride() -> StatementType.OVERRIDE_METHOD
        isPublic() -> StatementType.PUBLIC_METHOD
        isProtected() -> StatementType.PROTECTED_METHOD
        isPrivate() -> StatementType.PRIVATE_METHOD
        else -> StatementType.OTHER
    }.calculateWeight()
}

fun UField.getWeight(): Int = StatementType.FIELD.calculateWeight()

fun StatementType.calculateWeight(): Int = -ordinal

fun UMethod.isAbstract() = hasModifierProperty(PsiModifier.ABSTRACT)

fun UMethod.isPrivate() = hasModifierProperty(PsiModifier.PRIVATE)

fun UMethod.isProtected() = hasModifierProperty(PsiModifier.PROTECTED)

fun UMethod.isPublic() = hasModifierProperty(PsiModifier.PUBLIC)

fun UMethod.isOverride() =
    findSuperMethods().find { superMethod -> superMethod.name == name }?.let { true } ?: false
