//TODO remove file with 0.17.0
@file:Suppress("DEPRECATION")

package ch.tutteli.atrium.domain.builders.utils

import ch.tutteli.kbox.glue

/**
 * Represents a parameter object used to express the arguments `T, vararg T`
 * and provides utility functions to transform them.
 */
@Deprecated(
    "Use VarArgHelper from atrium-logic; will be removed with 0.17.0",
    ReplaceWith("ch.tutteli.atrium.logic.utils.VarArgHelper<T>")
)
interface VarArgHelper<out T> {
    /**
     * The first argument in the argument list `T, vararg T`
     */
    @Deprecated("Extend VarArgHelper from atrium-logic; will be removed with 0.17.0")
    val expected: T

    /**
     * The second argument in the argument list `T, vararg T`
     */
    @Deprecated("Extend VarArgHelper from atrium-logic; will be removed with 0.17.0")
    val otherExpected: Array<out T>

    /**
     * Creates an [ArgumentMapperBuilder] which allows to map [expected] and [otherExpected].
     */
    @Suppress("DeprecatedCallableAddReplaceWith")
    @Deprecated("Extend VarArgHelper from atrium-logic; will be removed with 0.17.0")
    val mapArguments: ArgumentMapperBuilder<T>
        get() = ArgumentMapperBuilder(expected, otherExpected)

    /**
     * Returns the arguments as [List].
     */
    @Suppress("DeprecatedCallableAddReplaceWith")
    @Deprecated("Extend VarArgHelper from atrium-logic; will be removed with 0.17.0")
    fun toList(): List<T> = expected glue otherExpected
}
